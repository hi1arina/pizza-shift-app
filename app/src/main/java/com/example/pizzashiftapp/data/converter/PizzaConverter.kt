package com.example.pizzashiftapp.data.converter

import com.example.pizzashiftapp.data.model.PizzaModel
import com.example.pizzashiftapp.domain.model.Pizza

class PizzaConverter(
    private val ingredientConverter: PizzaIngredientConverter,
    private val sizeConverter: PizzaSizeConverter,
    private val doughConverter: PizzaDoughsConverter
) {
    fun convert(from: PizzaModel): Pizza =
        with (from) {
            Pizza(
                id = id.toInt(),
                name = name,
                ingredients = ingredients.map { ingredientConverter.convert(it) },
                toppings = toppings.map { ingredientConverter.convert(it) },
                description = description,
                sizes = sizes.map { sizeConverter.convert(it) },
                doughs = doughs.map { doughConverter.convert(it) },
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