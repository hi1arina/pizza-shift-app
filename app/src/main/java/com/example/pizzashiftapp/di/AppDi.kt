package com.example.pizzashiftapp.di

import com.example.pizzashiftapp.presentation.CatalogViewModel
import com.example.pizzashiftapp.presentation.NutritionViewModel
import com.example.pizzashiftapp.presentation.PizzaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        CatalogViewModel()
    }

    viewModel {
        NutritionViewModel()
    }

    viewModel {
        PizzaViewModel()
    }
}