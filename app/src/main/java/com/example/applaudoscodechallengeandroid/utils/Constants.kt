package com.example.applaudoscodechallengeandroid.utils

import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {
    const val EMPTY_STRING = ""
    const val DATA_STORE_NAME = "applaudosDataStore"
    const val LOCAL_DATABASE_NAME = "ApplaudosLocalDatabase"
    const val CONTENT_DESCRIPTION_IMAGE_SPLASH_SCREEN = "splashScreenContentDescription"
    const val RECOMMENDED_ANIMATION_DURATION = 1000
    const val SPLASH_SCREEN_DELAY_DURATION = 1500L
    const val CONTENT_DESCRIPTION_IMAGE_LOGIN_SCREEN = "loginScreenImageContentDescription"

    //Errors
    const val ERROR_UNKNOWN = "UNKNOWN_ERROR"
    const val API_RESPONSE_CODE_401 = 401
    const val API_RESPONSE_CODE_402 = 402
    const val API_RESPONSE_CODE_403 = 403
    const val API_RESPONSE_CODE_404 = 404
    const val NO_ERROR_MESSAGE = ""

    //DataStore constants
    const val PREFERENCES_KEY_USER_API_TOKEN = "user_api_token"
    const val PREFERENCES_KEY_USER_LOGIN_TOKEN = "user_login_token"
    const val PREFERENCES_KEY_USER_EMAIL = "user_email"
    const val PREFERENCES_KEY_USER_NAME = "user_name"
}