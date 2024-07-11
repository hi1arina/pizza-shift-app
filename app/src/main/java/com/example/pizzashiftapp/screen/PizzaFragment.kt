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
import org.koin.core.component.KoinComponent

class PizzaFragment : Fragment(), KoinComponent {

    private var _binding: PizzaPageBinding? = null
    private val binding get() = _binding!!

    private lateinit var pizza: Pizza

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

        arguments?.getSerializable("pizza")?.let { pizza = it as Pizza }

        setupUi()
    }

    private fun setupUi() {
        with(binding){

            pizzaTitle.text = pizza.name
            pizzaIngredient.text = pizza.ingredients.joinToString(separator = ", ") { it.name }

            Glide.with(pizzaImg.context)
                .load(pizza.img)
                .into(pizzaImg)

            radioGroup.check(R.id.medium)
            updateButtonToCart(pizza.sizes[1].price.toString())

            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                val price = when (checkedId) {
                    R.id.small -> pizza.sizes[0].price
                    R.id.medium -> pizza.sizes[1].price
                    R.id.large -> pizza.sizes[2].price
                    else -> pizza.sizes[1].price
                }
                updateButtonToCart(price.toString())
            }
        }
    }

    private fun updateButtonToCart(price: String) {
        binding.buttonToCart.text = getString(R.string.add_to_cart, price.toDouble().toInt())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}