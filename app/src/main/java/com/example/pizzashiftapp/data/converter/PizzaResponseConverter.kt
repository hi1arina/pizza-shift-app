package com.example.pizzashiftapp.data.converter

import com.example.pizzashiftapp.data.model.PizzasResponseModel
import com.example.pizzashiftapp.domain.model.PizzasResponse

//вроде как и не нужен?
class PizzaResponseConverter(
    private val pizzaConverter: PizzaConverter
) {
    fun convert(from: PizzasResponseModel): PizzasResponse =
        with (from) {
            PizzasResponse(
                success = success,
                reason = reason ?: "",
                catalog = catalog.map { pizzaConverter.convert(it) }
            )
        }
}