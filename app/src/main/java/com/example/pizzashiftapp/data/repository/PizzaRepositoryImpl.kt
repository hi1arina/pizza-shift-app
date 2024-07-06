package com.example.pizzashiftapp.data.repository

import android.util.Log
import com.example.pizzashiftapp.data.PizzaApi
import com.example.pizzashiftapp.data.model.PizzasResponseModel
import com.example.pizzashiftapp.domain.model.Pizza
import com.example.pizzashiftapp.domain.repository.PizzaRepository

class PizzaRepositoryImpl(
    private val api: PizzaApi
): PizzaRepository {
    override suspend fun getAll(): List<Pizza> {
        return try {
            val response: PizzasResponseModel = api.getAll()
            Log.i("PizzaRepositoryImpl", "API ответ : $response")
            if (response.success) {
                val pizzas = response.convert().catalog
                Log.i("PizzaRepositoryImpl", "Конвертировали :) : $pizzas")
                pizzas
            } else {
                Log.i("PizzaRepositoryImpl", "API провал :( : ${response.reason}")
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("PizzaRepositoryImpl", "Exception: ${e.localizedMessage}")
            emptyList()
        }
    }

}