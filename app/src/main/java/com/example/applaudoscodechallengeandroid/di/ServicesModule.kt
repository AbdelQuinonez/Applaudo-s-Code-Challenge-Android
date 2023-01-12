package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.remotedatasource.api.TvShowService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Binds
    @Singleton
    fun provideTvShowService(
        retrofit: Retrofit,
    ): TvShowService =
        retrofit.create(TvShowService::class.java)

}