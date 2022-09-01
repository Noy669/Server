package com.example.server.data.di

import com.example.server.data.repository.MainRepositoryImpl
import com.example.server.domain.repository.MainRepository
import org.koin.dsl.module

var repoModule = module {
    factory<MainRepository> { MainRepositoryImpl(get()) }
}