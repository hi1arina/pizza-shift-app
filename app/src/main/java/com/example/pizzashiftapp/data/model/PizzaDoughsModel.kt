package com.example.pizzashiftapp.data.model

import com.example.pizzashiftapp.domain.model.PizzaDoughs
import com.example.pizzashiftapp.domain.model.PizzaDoughsType

data class PizzaDoughsModel(
    val name: String,
    val price: Double,
){
    fun convert(): PizzaDoughs =
        PizzaDoughs(
            name = name,
            price= price
        )

}

