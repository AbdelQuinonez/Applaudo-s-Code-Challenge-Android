package com.example.applaudoscodechallengeandroid.localdatasource

import kotlinx.coroutines.flow.Flow

interface UserPreferences {

    fun getApiToken(): Flow<String>
    fun getLoginToken(): Flow<String>
    fun getEmail(): Flow<String>
    fun getName(): Flow<String>

    suspend fun setApiToken(value: String)
    suspend fun setLoginToken(value: String)
    suspend fun setEmail(value: String)
    suspend fun setName(value: String)
}