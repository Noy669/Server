package com.example.server.presentation

import android.app.Application
import com.example.server.di.apiModule
import com.example.server.data.di.repoModule
import com.example.server.domain.di.useCaseModule
import com.example.server.presentation.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RetrofitApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RetrofitApp)
            modules(listOf(apiModule, repoModule, viewModule, useCaseModule))
        }
    }
}