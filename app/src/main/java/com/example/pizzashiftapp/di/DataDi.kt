package com.example.pizzashiftapp.di

import com.example.pizzashiftapp.data.PizzaApi
import com.example.pizzashiftapp.data.converter.PizzaConverter
import com.example.pizzashiftapp.data.converter.PizzaDoughsConverter
import com.example.pizzashiftapp.data.converter.PizzaIngredientConverter
import com.example.pizzashiftapp.data.converter.PizzaResponseConverter
import com.example.pizzashiftapp.data.converter.PizzaSizeConverter
import com.example.pizzashiftapp.data.repository.PizzaRepositoryImpl
import com.example.pizzashiftapp.domain.repository.PizzaRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://shift-backend.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<PizzaApi> {
        get<Retrofit>().create(PizzaApi::class.java)
    }

    single<PizzaRepository> {
        PizzaRepositoryImpl(get(), get())
    }

    single<PizzaIngredientConverter> {
        PizzaIngredientConverter(get())
    }

    single<PizzaSizeConverter> {
        PizzaSizeConverter()
    }

    single<PizzaDoughsConverter> {
        PizzaDoughsConverter()
    }

    single { "https://shift-backend.onrender.com" }

    single<PizzaConverter> {
        PizzaConverter(get(), get(), get(), get())
    }

    single<PizzaResponseConverter> {
        PizzaResponseConverter(get())
    }
}