package com.example.pizzashiftapp.data.model

import com.example.pizzashiftapp.domain.model.PizzaSize
import com.example.pizzashiftapp.domain.model.PizzaSizeType

data class PizzaSizeModel(
    val name: String,
    val price: Double,
){
    fun convert(): PizzaSize =
        PizzaSize(
            name = name,
            price = price
        )
}