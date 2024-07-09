package com.example.pizzashiftapp.di

import com.example.pizzashiftapp.data.PizzaApi
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
        PizzaRepositoryImpl(get())
    }
}