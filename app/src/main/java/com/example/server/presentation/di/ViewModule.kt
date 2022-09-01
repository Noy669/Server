package com.example.server.presentation.di

import com.example.server.mvvm.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModule = module {
    viewModel { MainViewModel(get()) }
}