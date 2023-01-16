package com.example.applaudoscodechallengeandroid.localdatasource

import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.applaudoscodechallengeandroid.ui.utils.Constants.PREFERENCES_KEY_USER_API_TOKEN
import com.example.applaudoscodechallengeandroid.ui.utils.Constants.PREFERENCES_KEY_USER_EMAIL
import com.example.applaudoscodechallengeandroid.ui.utils.Constants.PREFERENCES_KEY_USER_LOGIN_TOKEN
import com.example.applaudoscodechallengeandroid.ui.utils.Constants.PREFERENCES_KEY_USER_NAME

object PreferencesKeys {
    val USER_API_TOKEN = stringPreferencesKey(PREFERENCES_KEY_USER_API_TOKEN)
    val USER_LOGIN_TOKEN = stringPreferencesKey(PREFERENCES_KEY_USER_LOGIN_TOKEN)
    val USER_EMAIL = stringPreferencesKey(PREFERENCES_KEY_USER_EMAIL)
    val USER_NAME = stringPreferencesKey(PREFERENCES_KEY_USER_NAME)
}