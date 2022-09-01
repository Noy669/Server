package com.example.server.presentation.model


data class ResponseResult(
    var status: String? = null,
    var totalResult: Int? = null,
    var articles: ArrayList<Article>? =null
)
