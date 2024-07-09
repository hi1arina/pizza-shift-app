package com.example.pizzashiftapp

import android.app.Application
import com.example.pizzashiftapp.di.appModule
import com.example.pizzashiftapp.di.dataModule
import com.example.pizzashiftapp.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, appModule)
        }
    }
}