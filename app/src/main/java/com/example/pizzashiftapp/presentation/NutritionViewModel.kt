package com.example.pizzashiftapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzashiftapp.domain.model.Pizza

class NutritionViewModel : ViewModel() {
    private val _nutrition = MutableLiveData<Pizza>()
    val nutrition: LiveData<Pizza> get() = _nutrition

    fun setNutrition(nutrition: Pizza) {
        _nutrition.value = nutrition
    }
}