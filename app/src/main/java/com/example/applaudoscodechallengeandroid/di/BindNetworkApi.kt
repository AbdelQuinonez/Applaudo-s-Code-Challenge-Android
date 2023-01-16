package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.ui.utils.NetworkApi
import com.example.applaudoscodechallengeandroid.ui.utils.NetworkApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindNetworkApi {

    @Binds
    @Singleton
    abstract fun bindNetworkApi(networkApiImpl: NetworkApiImpl): NetworkApi

}