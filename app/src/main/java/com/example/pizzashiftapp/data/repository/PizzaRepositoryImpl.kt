package com.example.pizzashiftapp.data.repository

import android.util.Log
import com.example.pizzashiftapp.data.PizzaApi
import com.example.pizzashiftapp.data.converter.PizzaConverter
import com.example.pizzashiftapp.data.model.PizzasResponseModel
import com.example.pizzashiftapp.domain.model.Pizza
import com.example.pizzashiftapp.domain.repository.PizzaRepository
import kotlin.coroutines.cancellation.CancellationException

class PizzaRepositoryImpl(
    private val api: PizzaApi
): PizzaRepository {

    private val converter = PizzaConverter()

    override suspend fun getAll(): List<Pizza> {
        return try {
            val response: PizzasResponseModel = api.getAll()
            Log.i("PizzaRepositoryImpl", "API ответ : $response")
            if (response.success) {
                val pizzas = response.catalog.map { converter.convert(it) }
                Log.i("PizzaRepositoryImpl", "Конвертировали :) : $pizzas")
                pizzas
            } else {
                Log.i("PizzaRepositoryImpl", "API провал :( : ${response.reason}")
                emptyList()
            }
        } catch (e: Exception) {
            if (e !is CancellationException) {
                e.printStackTrace()
                Log.e("PizzaRepositoryImpl", "Exception: ${e.localizedMessage}")
            }
            emptyList()
        }
    }

}