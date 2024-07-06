package com.example.pizzashiftapp.data.model

import com.example.pizzashiftapp.domain.model.PizzasResponse

data class PizzasResponseModel(
    val success: Boolean,
    val reason: String?,
    val catalog: List<PizzaModel>
){
    fun convert(): PizzasResponse =
        PizzasResponse(
            success = success,
            reason = reason ?: "",
            catalog = catalog.map { it.convert() }
        )
}