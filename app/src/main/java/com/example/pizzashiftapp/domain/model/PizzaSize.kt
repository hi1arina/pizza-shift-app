package com.example.pizzashiftapp.domain.model

import java.io.Serializable

data class PizzaSize(
    val name: String,
    val price: Double,
) : Serializable