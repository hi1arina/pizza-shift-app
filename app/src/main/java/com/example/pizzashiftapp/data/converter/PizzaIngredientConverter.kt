package com.example.pizzashiftapp.data.converter

import com.example.pizzashiftapp.data.model.PizzaIngredientModel
import com.example.pizzashiftapp.domain.model.PizzaIngredient

class PizzaIngredientConverter {
    fun convert(from: PizzaIngredientModel): PizzaIngredient =
        with (from) {
            PizzaIngredient(
                name = name,
                cost = cost,
                img = img
            )
        }
}