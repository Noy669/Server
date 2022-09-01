package com.example.server.data.repository

import com.example.server.data.api.ApiService
import com.example.server.domain.repository.MainRepository
import com.example.server.presentation.model.ResponseResult
import com.example.server.presentation.model.ActionResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepositoryImpl(var apiService: ApiService) : MainRepository {

    override suspend fun requestData(
        country: String,
        category: String,
        apiKey:String
    ): ActionResult<ResponseResult> {
        return withContext(Dispatchers.IO) {
            val result = apiService.getArticles(country,category, apiKey )
            when (result.code()) {
                200 -> {
                    return@withContext ActionResult.SUCCESS("Success", result.body())
                }
                else -> {
                    return@withContext ActionResult.ERROR("Success")
                }
            }
        }
    }
}