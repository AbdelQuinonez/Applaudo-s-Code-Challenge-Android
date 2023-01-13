package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.data.TvShowRepository
import com.example.applaudoscodechallengeandroid.data.TvShowRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindTvShowRepository {

    @Binds
    @Singleton
    abstract fun bindTvShowRepository(tvShowRepositoryImpl: TvShowRepositoryImpl): TvShowRepository

}