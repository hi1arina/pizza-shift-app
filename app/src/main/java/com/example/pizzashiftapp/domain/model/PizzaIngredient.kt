package com.example.pizzashiftapp.domain.model

import java.io.Serializable

data class PizzaIngredient(
    val name: String,
    val cost: Double,
    val img: String
) : Serializable