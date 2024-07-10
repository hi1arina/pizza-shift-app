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
import org.koin.core.component.KoinComponent

class PizzaFragment : Fragment(), KoinComponent {

    private var _binding: PizzaPageBinding? = null
    private val binding get() = _binding!!

    private var pizzaId: Int = 0
    private lateinit var price: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PizzaPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        arguments?.let {
            pizzaId = it.getInt("id")
            binding.pizzaTitle.text = it.getString("name")
            binding.pizzaIngredient.text = it.getStringArray("ingredients")?.joinToString(separator = ", ")
            val img = it.getString("img")
            Glide.with(binding.pizzaImg.context)
                .load("https://shift-backend.onrender.com${img}")
                .into(binding.pizzaImg)
            price = it.getStringArray("price")!!
        }

        binding.radioGroup.check(R.id.medium)
        binding.buttonToCart.text = getString(R.string.add_to_cart, price[1].toDouble().toInt())

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.small -> binding.buttonToCart.text = getString(R.string.add_to_cart, price[0].toDouble().toInt())
                R.id.medium -> binding.buttonToCart.text = getString(R.string.add_to_cart, price[1].toDouble().toInt())
                R.id.large -> binding.buttonToCart.text = getString(R.string.add_to_cart, price[2].toDouble().toInt())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}