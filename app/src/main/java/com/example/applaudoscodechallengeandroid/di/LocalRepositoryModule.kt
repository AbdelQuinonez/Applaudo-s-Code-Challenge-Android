package com.example.applaudoscodechallengeandroid.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.example.applaudoscodechallengeandroid.localdatasource.UserPreferences
import com.example.applaudoscodechallengeandroid.localdatasource.UserPreferencesImpl
import com.example.applaudoscodechallengeandroid.localdatasource.database.AppDatabase
import com.example.applaudoscodechallengeandroid.utils.AppDispatcher
import com.example.applaudoscodechallengeandroid.utils.Constants.DATA_STORE_NAME
import com.example.applaudoscodechallengeandroid.utils.Constants.LOCAL_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalRepositoryModule {

    @Provides
    @Singleton
    fun provideRoomInstance(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, LOCAL_DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun provideDataStore(application: Application, dispatcher: AppDispatcher): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            scope = CoroutineScope(dispatcher.io() + SupervisorJob()),
            produceFile = { application.preferencesDataStoreFile(DATA_STORE_NAME) }
        )

    @Provides
    @Singleton
    fun provideUserPreferences(dataStore: DataStore<Preferences>): UserPreferences {
        return UserPreferencesImpl(dataStore)
    }

}