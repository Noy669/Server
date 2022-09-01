package com.example.server.domain.interactor

import com.example.server.presentation.model.ResponseResult
import com.example.server.presentation.model.ActionResult

interface RequestDataUseCase {
    suspend fun invoke(country: String, category: String, apiKey:String): ActionResult<ResponseResult>
}