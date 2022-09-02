package com.example.server.domain.repository

import com.example.server.presentation.model.ActionResult
import com.example.server.presentation.model.ResponseResult

interface MainRepository {
    suspend fun requestData(country: String, category: String, apiKey:String): ActionResult<ResponseResult>
}