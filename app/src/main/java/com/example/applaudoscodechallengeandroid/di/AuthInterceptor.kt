package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.localdatasource.UserPreferences
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val userPreferences: UserPreferences): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var jwt = ""
        runBlocking {
            jwt = userPreferences.getApiToken().first()
        }
        val request = chain.request()
        val requestBuilder = request.newBuilder()

        if (jwt.isNotEmpty()) {
            requestBuilder.addHeader("Authorization", "Bearer $jwt")
        }

        return chain.proceed(requestBuilder.build())
    }
}