package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.remotedatasource.datasource.TvShowRemoteDataSource
import com.example.applaudoscodechallengeandroid.remotedatasource.datasource.TvShowRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindTvShowDataSource {

    @Binds
    @Singleton
    abstract fun bindTvShowService(tvShowRemoteDataSourceImpl: TvShowRemoteDataSourceImpl) : TvShowRemoteDataSource

}