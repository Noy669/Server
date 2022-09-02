package com.example.server.domain.usecase

import com.example.server.domain.interactor.RequestDataUseCase
import com.example.server.domain.repository.MainRepository
import com.example.server.presentation.model.ActionResult
import com.example.server.presentation.model.ResponseResult

class RequestDataUseCaseImpl(
    var repository: MainRepository
) : RequestDataUseCase {

    override suspend fun invoke(country:String,category:String,apiKey:String): ActionResult<ResponseResult> {
        return repository.requestData(country,category,apiKey)
    }
}