package com.example.pizzashiftapp.data.model

import com.example.pizzashiftapp.domain.model.PizzaIngredient
import com.example.pizzashiftapp.domain.model.PizzaIngredientType

data class PizzaIngredientModel(
    val name: String,
    val cost: Double,
    val img: String
){
    fun convert(): PizzaIngredient =
        PizzaIngredient(
            name = name,
            cost = cost,
            img = img
        )
}