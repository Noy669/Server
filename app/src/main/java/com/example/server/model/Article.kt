package com.example.server.model

import com.example.datares.model.Source

data class Article(
    val source: Source,
    var author: String,
    var title: String,
    var description:String,
    var url:String,
    var urlToImage:String,
    var publishedAt:String,
    var content:String
    )
