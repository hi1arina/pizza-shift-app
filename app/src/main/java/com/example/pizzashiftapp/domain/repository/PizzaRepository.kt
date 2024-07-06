package com.example.pizzashiftapp.domain.repository

import com.example.pizzashiftapp.domain.model.Pizza

interface PizzaRepository {

    suspend fun getAll(): List<Pizza>
}