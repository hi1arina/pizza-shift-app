package com.example.pizzashiftapp.data.model

data class PizzasResponseModel(
    val success: Boolean,
    val reason: String?,
    val catalog: List<PizzaModel>
)