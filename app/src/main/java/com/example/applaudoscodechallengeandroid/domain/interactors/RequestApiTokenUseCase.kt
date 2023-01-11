package com.example.applaudoscodechallengeandroid.domain.interactors

import com.example.applaudoscodechallengeandroid.localdatasource.UserPreferences
import com.example.applaudoscodechallengeandroid.utils.Constants
import javax.inject.Inject

class RequestApiTokenUseCase @Inject constructor(
    private val userPreferences: UserPreferences
) {
    suspend operator fun invoke(){
        userPreferences.setApiToken(Constants.API_TOKEN)
    }
}