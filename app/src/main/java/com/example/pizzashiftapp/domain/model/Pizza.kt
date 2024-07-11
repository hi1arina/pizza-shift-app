package com.example.pizzashiftapp.domain.model

import java.io.Serializable

data class Pizza(
    val id: Int,
    val name: String,
    val ingredients: List<PizzaIngredient>,
    val toppings: List<PizzaIngredient>,
    val description: String,
    val sizes: List<PizzaSize>,
    val doughs: List<PizzaDoughs>,
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
) : Serializable