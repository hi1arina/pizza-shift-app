package com.example.pizzashiftapp.di

import com.example.pizzashiftapp.presentation.CatalogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        CatalogViewModel()
    }
}