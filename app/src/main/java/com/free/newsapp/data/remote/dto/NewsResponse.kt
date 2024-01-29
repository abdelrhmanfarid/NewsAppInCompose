package com.free.newsapp.data.remote.dto

import com.free.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)