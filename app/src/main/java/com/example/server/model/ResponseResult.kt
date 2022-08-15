package com.example.server.model

import com.example.server.model.Article

data class ResponseResult(
    var status:String,
    var totalResult: Int,
    var articles : ArrayList<Article>

)
