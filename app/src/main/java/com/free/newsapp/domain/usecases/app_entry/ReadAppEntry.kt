package com.free.newsapp.domain.usecases.app_entry

import com.free.newsapp.domain.manager.LocalUerManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (
    private val localUerManger: LocalUerManger
) {

     operator fun invoke(): Flow<Boolean> {
       return localUerManger.readAppEntry()
    }
}