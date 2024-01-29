package com.free.newsapp.domain.usecases.newsUseCase

import androidx.paging.PagingData
import com.free.newsapp.domain.model.Article
import com.free.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery, sources = sources)
    }
}