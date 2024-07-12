package com.example.pizzashiftapp.screen

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.pizzashiftapp.R
import com.example.pizzashiftapp.databinding.DialogInfoBinding
import com.example.pizzashiftapp.domain.model.Pizza
import com.example.pizzashiftapp.presentation.NutritionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NutritionDialogFragment : DialogFragment() {

    private var _binding: DialogInfoBinding? = null
    private val binding get() = _binding!!
    private val nutritionViewModel: NutritionViewModel by viewModel()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_background)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getSerializable("pizza")?.let {
            nutritionViewModel.setNutrition(it as Pizza)
        }

        nutritionViewModel.nutrition.observe(viewLifecycleOwner) { nutrition ->
            setupUi(nutrition)
        }
    }

    private fun setupUi(pizza: Pizza) {
        with(binding) {
            calories.text = pizza.calories.toInt().toString()
            protein.text = justNumber(pizza.protein)
            totalFat.text = justNumber(pizza.totalFat)
            carbohydrates.text = justNumber(pizza.carbohydrates)
            sodium.text = justNumber(pizza.sodium)
            allergen.text = pizza.allergens.joinToString(separator = ", ")
        }
    }

    private fun justNumber(text: String): String {
        return text.replace(Regex("[^0-9,]"), "")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}