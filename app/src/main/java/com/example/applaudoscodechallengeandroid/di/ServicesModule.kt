package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.remotedatasource.api.TvShowService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Provides
    @Singleton
    fun provideTvShowService(
        retrofit: Retrofit,
    ): TvShowService =
        retrofit.create(TvShowService::class.java)

}