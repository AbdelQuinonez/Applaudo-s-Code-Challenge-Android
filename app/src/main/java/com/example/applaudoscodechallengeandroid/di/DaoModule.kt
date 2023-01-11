package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.localdatasource.database.AppDatabase
import com.example.applaudoscodechallengeandroid.localdatasource.database.daos.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideTvShowDao(appDatabase: AppDatabase): TvShowDao =
        appDatabase.tvShow()

}