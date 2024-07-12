package com.example.pizzashiftapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzashiftapp.R
import com.example.pizzashiftapp.domain.model.Pizza

class PizzaViewModel : ViewModel() {

    private val _pizza = MutableLiveData<Pizza>()
    val pizza: LiveData<Pizza> get() = _pizza

    fun setPizza(pizza: Pizza) {
        _pizza.value = pizza
    }

    fun getPrice(checkedId: Int): Double {
        return when (checkedId) {
            R.id.small -> _pizza.value?.sizes?.get(0)?.price ?: 0.0
            R.id.medium -> _pizza.value?.sizes?.get(1)?.price ?: 0.0
            R.id.large -> _pizza.value?.sizes?.get(2)?.price ?: 0.0
            else -> _pizza.value?.sizes?.get(1)?.price ?: 0.0
        }
    }
}