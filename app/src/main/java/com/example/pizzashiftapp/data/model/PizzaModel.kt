package com.example.pizzashiftapp.data.model

import com.example.pizzashiftapp.domain.model.Pizza

data class PizzaModel(
    val id: String,
    val name: String,
    val ingredients: List<PizzaIngredientModel>,
    val toppings: List<PizzaIngredientModel>,
    val description: String,
    val sizes: List<PizzaSizeModel>,
    val doughs: List<PizzaDoughsModel>,
    val calories: Double,
    val protein: String,
    val totalFat: String,
    val carbohydrates: String,
    val sodium: String,
    val allergens: List<String>,
    val isVegetarian: Boolean,
    val isGlutenFree: Boolean,
    val isNew: Boolean,
    val isHit: Boolean,
    val img: String
){
    fun convert(): Pizza =
        Pizza(
            id = id.toInt(),
            name = name,
            ingredients = ingredients.map { it.convert() },
            toppings = toppings.map { it.convert() },
            description = description,
            sizes = sizes.map { it.convert() },
            doughs = doughs.map { it.convert() },
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