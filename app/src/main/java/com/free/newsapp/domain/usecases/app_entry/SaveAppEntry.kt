package com.free.newsapp.domain.usecases.app_entry

import com.free.newsapp.domain.manager.LocalUerManger

class SaveAppEntry(
    private val localUerManger: LocalUerManger
) {

    suspend operator fun invoke(){
        localUerManger.saveAppEntry()
    }
}