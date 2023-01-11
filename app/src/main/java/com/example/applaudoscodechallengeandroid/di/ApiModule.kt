package com.example.applaudoscodechallengeandroid.di

import com.example.applaudoscodechallengeandroid.localdatasource.UserPreferences
import com.example.applaudoscodechallengeandroid.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private fun getOkHttpClientBuilder(): OkHttpClient.Builder {
        // Timeout setup
        val okHttpClientBuilder = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        // Failure retry setup
        okHttpClientBuilder.retryOnConnectionFailure(true)

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder.addInterceptor(logging)

        return okHttpClientBuilder
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        userPreferences: UserPreferences,
    ): OkHttpClient {
        val okHttpClientBuilder = getOkHttpClientBuilder()

        // TODO("clear and redirect user to login if unauthorized")
        okHttpClientBuilder.addInterceptor(AuthInterceptor(userPreferences))

        // App specific configuration
        okHttpClientBuilder.addInterceptor { chain ->
            val request = chain.request()
            val builder = request.newBuilder()
            builder.addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
            val response = chain.proceed(request)

            response
        }

        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

}
