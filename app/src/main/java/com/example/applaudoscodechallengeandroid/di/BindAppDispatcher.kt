package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.utils.AppDispatcher
import com.example.applaudoscodechallengeandroid.utils.AppDispatcherImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindAppDispatcher {

    @Binds
    @Singleton
    abstract fun bindAppDispatcher(appDispatcherImpl: AppDispatcherImpl): AppDispatcher

}