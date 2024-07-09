package com.example.pizzashiftapp.data.converter

import com.example.pizzashiftapp.data.model.PizzaModel
import com.example.pizzashiftapp.domain.model.Pizza

class PizzaConverter {
    fun convert(from: PizzaModel): Pizza =
        with (from) {
            Pizza(
                id = id.toInt(),
                name = name,
                ingredients = ingredients.map { PizzaIngredientConverter().convert(it) },
                toppings = toppings.map { PizzaIngredientConverter().convert(it) },
                description = description,
                sizes = sizes.map { PizzaSizeConverter().convert(it) },
                doughs = doughs.map { PizzaDoughsConverter().convert(it) },
                calories = calories,
                protein = protein,
                totalFat = totalFat,
                carbohydrates = carbohydrates,
                sodium = sodium,
                allergens = allergens,
                isVegetarian = isVegetarian,
                isGlutenFree = isGlutenFree,
                isNew = isNew,
                isHit = isHit,
                img = img
            )
        }
}