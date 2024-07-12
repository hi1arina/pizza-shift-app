package com.example.pizzashiftapp.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pizzashiftapp.R
import com.example.pizzashiftapp.databinding.PizzaPageBinding
import com.example.pizzashiftapp.domain.model.Pizza
import com.example.pizzashiftapp.domain.model.PizzaIngredientType
import com.example.pizzashiftapp.domain.model.ingredientTranslationMap
import com.example.pizzashiftapp.presentation.PizzaViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PizzaFragment : Fragment() {

    private lateinit var toppingAdapter: ToppingAdapter
    private var _binding: PizzaPageBinding? = null
    private val binding get() = _binding!!
    private val pizzaViewModel: PizzaViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PizzaPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowIcon.setOnClickListener { findNavController().navigateUp() }

        arguments?.getSerializable("pizza")?.let { pizza ->
            pizzaViewModel.setPizza(pizza as Pizza)
        }

        binding.infoIcon.setOnClickListener {
            pizzaViewModel.pizza.value?.let { pizza ->
                val bundle = Bundle().apply {
                    putSerializable("pizza", pizza)
                }
                findNavController().navigate(R.id.action_pizzaFragment_to_nutritionDialogFragment, bundle)
            }
        }

        pizzaViewModel.pizza.observe(viewLifecycleOwner) { pizza ->
            setupUi(pizza)
        }

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val price = pizzaViewModel.getPrice(checkedId)
            updateButtonToCart(price.toString())
        }
    }

    private fun setupUi(pizza: Pizza) {
        with(binding){

            pizzaTitle.text = pizza.name

            val ingredientsRu = pizza.ingredients.joinToString(separator = ", ") {
                translateIngredient(it.name)
            }
            pizzaIngredient.text = ingredientsRu

            Glide.with(pizzaImg.context)
                .load(pizza.img)
                .into(pizzaImg)

            radioGroup.check(R.id.medium)
            updateButtonToCart(pizza.sizes[1].price.toString())
        }

        toppingAdapter = ToppingAdapter()
        binding.toppingsSet.adapter = toppingAdapter
        toppingAdapter.setCatalog(pizza.toppings)
    }

    private fun updateButtonToCart(price: String) {
        binding.buttonToCart.text = getString(R.string.add_to_cart, price.toDouble().toInt())
    }

    private fun translateIngredient(name: String): String {
        val type = PizzaIngredientType.entries.find { it.name.equals(name, ignoreCase = true) }
        return type?.let { ingredientTranslationMap[it] } ?: name
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}