package com.example.server.API

import com.example.server.model.ResponseResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
    fun getArticles(
        @Query("country") country:String,
        @Query("apiKey") apiKey:String = Constants.API_KEY,
        @Query("category") category:String
    ):Call<ResponseResult>
}