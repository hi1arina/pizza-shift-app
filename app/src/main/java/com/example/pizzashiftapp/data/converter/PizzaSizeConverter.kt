package com.example.pizzashiftapp.data.converter

import com.example.pizzashiftapp.data.model.PizzaSizeModel
import com.example.pizzashiftapp.domain.model.PizzaSize

class PizzaSizeConverter {
    fun convert(from: PizzaSizeModel): PizzaSize =
        with (from){
            PizzaSize(
                name = name,
                price = price
            )
        }
}