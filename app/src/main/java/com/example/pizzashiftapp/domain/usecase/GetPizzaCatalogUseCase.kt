package com.example.pizzashiftapp.domain.usecase

import com.example.pizzashiftapp.domain.repository.PizzaRepository

class GetPizzaCatalogUseCase(
    private val repository: PizzaRepository
) {
    suspend operator fun invoke() = repository.getAll()
}