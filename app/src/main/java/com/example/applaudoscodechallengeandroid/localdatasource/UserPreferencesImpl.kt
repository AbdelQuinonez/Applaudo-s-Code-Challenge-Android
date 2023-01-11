package com.e1technology.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.example.applaudoscodechallengeandroid.localdatasource.PreferencesKeys
import com.example.applaudoscodechallengeandroid.utils.Constants.EMPTY_STRING
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class UserPreferencesImpl @Inject constructor(private val dataStore: DataStore<Preferences>) :
    UserPreferences {

    override fun getApiToken() = dataStore.data.catch { exception -> // 1
        // dataStore.data throws an IOException if it can't read the data
        if (exception is IOException) { // 2
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { it[PreferencesKeys.USER_API_TOKEN] ?: EMPTY_STRING }

    override fun getLoginToken() = dataStore.data.catch { exception -> // 1
        // dataStore.data throws an IOException if it can't read the data
        if (exception is IOException) { // 2
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { it[PreferencesKeys.USER_LOGIN_TOKEN] ?: EMPTY_STRING }

    override fun getEmail() = dataStore.data.catch { exception -> // 1
        // dataStore.data throws an IOException if it can't read the data
        if (exception is IOException) { // 2
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { it[PreferencesKeys.USER_EMAIL] ?: EMPTY_STRING }

    override fun getName() = dataStore.data.catch { exception -> // 1
        // dataStore.data throws an IOException if it can't read the data
        if (exception is IOException) { // 2
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { it[PreferencesKeys.USER_NAME] ?: EMPTY_STRING }

    override suspend fun setApiToken(value: String) {
        try {
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.USER_API_TOKEN] = value
            }
            // If you got here, the preferences were successfully committed
        } catch (e: IOException) {
            // Handle error writing preferences to disk
        } catch (e: Exception) {
            // Handle error thrown while executing transform block
        }
    }

    override suspend fun setLoginToken(value: String) {
        try {
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.USER_LOGIN_TOKEN] = value
            }
            // If you got here, the preferences were successfully committed
        } catch (e: IOException) {
            // Handle error writing preferences to disk
        } catch (e: Exception) {
            // Handle error thrown while executing transform block
        }
    }

    override suspend fun setEmail(value: String) {
        try {
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.USER_EMAIL] = value
            }
            // If you got here, the preferences were successfully committed
        } catch (e: IOException) {
            // Handle error writing preferences to disk
        } catch (e: Exception) {
            // Handle error thrown while executing transform block
        }
    }

    override suspend fun setName(value: String) {
        try {
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.USER_NAME] = value
            }
            // If you got here, the preferences were successfully committed
        } catch (e: IOException) {
            // Handle error writing preferences to disk
        } catch (e: Exception) {
            // Handle error thrown while executing transform block
        }
    }

}