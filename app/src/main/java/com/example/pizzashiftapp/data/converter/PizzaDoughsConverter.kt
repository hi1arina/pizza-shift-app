package com.example.pizzashiftapp.data.converter

import com.example.pizzashiftapp.data.model.PizzaDoughsModel
import com.example.pizzashiftapp.domain.model.PizzaDoughs

class PizzaDoughsConverter {
    fun convert(from: PizzaDoughsModel): PizzaDoughs =
        with (from) {
            PizzaDoughs(
                name = name,
                price= price
            )
        }
}