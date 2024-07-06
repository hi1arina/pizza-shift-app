package com.example.pizzashiftapp.data

import com.example.pizzashiftapp.data.model.PizzasResponseModel
import retrofit2.http.GET

interface PizzaApi {

    @GET("/pizza/catalog")
    suspend fun getAll(): PizzasResponseModel

}