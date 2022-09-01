package com.example.server.domain.di

import com.example.server.domain.interactor.RequestDataUseCase
import com.example.server.domain.usecase.RequestDataUseCaseImpl
import org.koin.dsl.module

var useCaseModule = module {
    factory<RequestDataUseCase> { RequestDataUseCaseImpl(get()) }
}