package com.example.pizzashiftapp.data.model

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
)