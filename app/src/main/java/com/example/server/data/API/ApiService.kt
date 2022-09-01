package com.example.server.data.api

import com.example.server.presentation.model.ResponseResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
    suspend fun getArticles(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey:String
    ): Response<ResponseResult>
}

