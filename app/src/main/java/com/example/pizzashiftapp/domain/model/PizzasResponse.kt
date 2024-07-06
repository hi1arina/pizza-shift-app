package com.example.pizzashiftapp.domain.model

data class PizzasResponse(
    val success: Boolean,
    val reason: String?,
    val catalog: List<Pizza>
)