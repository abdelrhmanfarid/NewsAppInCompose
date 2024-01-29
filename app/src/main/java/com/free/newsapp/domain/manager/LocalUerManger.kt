package com.free.newsapp.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUerManger {
    suspend fun saveAppEntry()

    fun readAppEntry():Flow<Boolean>
}