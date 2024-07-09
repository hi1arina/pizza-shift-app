package com.example.pizzashiftapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashiftapp.domain.model.Pizza
import com.example.pizzashiftapp.domain.usecase.GetPizzaCatalogUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CatalogViewModel : ViewModel(), KoinComponent {

    private val getPizzaCatalogUseCase: GetPizzaCatalogUseCase by inject()

    private val _pizzas = MutableLiveData<List<Pizza>>()
    val pizzas: LiveData<List<Pizza>> = _pizzas

    fun load() {
        viewModelScope.launch {
            try {
                val catalog = getPizzaCatalogUseCase.invoke()
                _pizzas.value = catalog
            } catch (e: Exception) {
                Log.e("CatalogViewModel", "Ошибка загрузки пицц: ", e)
            }
        }
    }
}