package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.localdatasource.LocalRepository
import com.example.applaudoscodechallengeandroid.localdatasource.LocalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindLocalRepository {

    @Binds
    @Singleton
    abstract fun bindLocalRepository(localRepositoryImpl: LocalRepositoryImpl): LocalRepository

}