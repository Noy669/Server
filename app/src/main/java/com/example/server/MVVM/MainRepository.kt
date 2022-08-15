package com.example.server.MVVM

import com.example.server.API.ApiClient
import com.example.server.API.ApiService
import com.example.server.model.ResponseResult
import retrofit2.Call
import retrofit2.Retrofit

class MainRepository {
    private lateinit var service: ApiService
    private lateinit var client: Retrofit

    init {
        client = ApiClient.getRetrofit()
        service = client.create(ApiService::class.java)
    }

    fun getArticles(apiKey: String): Call<ResponseResult> {
        return service.getArticles(apiKey = apiKey, category = "business", country = "us")

    }
}