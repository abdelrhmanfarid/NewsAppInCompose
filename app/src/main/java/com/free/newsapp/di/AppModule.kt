package com.free.newsapp.di

import android.app.Application
import com.free.newsapp.data.manager.LocalUserMangerImpl
import com.free.newsapp.data.remote.NewsApi
import com.free.newsapp.data.remote.repositoryImplementation.NewsRepositoryImpl
import com.free.newsapp.domain.manager.LocalUerManger
import com.free.newsapp.domain.repository.NewsRepository
import com.free.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.free.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.free.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.free.newsapp.domain.usecases.newsUseCase.GetNews
import com.free.newsapp.domain.usecases.newsUseCase.NewsUseCases
import com.free.newsapp.domain.usecases.newsUseCase.SearchNews
import com.free.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUerManger =
        LocalUserMangerImpl(application)


    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUerManger: LocalUerManger
    ) = AppEntryUseCases(
        SaveAppEntry(localUerManger),
        ReadAppEntry(localUerManger)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)

    }


    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }


}