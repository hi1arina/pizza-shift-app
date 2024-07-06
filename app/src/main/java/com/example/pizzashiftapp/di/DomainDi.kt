package com.example.pizzashiftapp.di

import com.example.pizzashiftapp.domain.usecase.GetPizzaCatalogUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetPizzaCatalogUseCase> {
        GetPizzaCatalogUseCase(get())
    }
}