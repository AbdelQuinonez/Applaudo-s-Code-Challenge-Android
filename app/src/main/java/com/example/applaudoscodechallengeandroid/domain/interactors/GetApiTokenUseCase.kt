package com.example.applaudoscodechallengeandroid.domain.interactors

import com.example.applaudoscodechallengeandroid.localdatasource.UserPreferences
import com.example.applaudoscodechallengeandroid.ui.utils.Constants
import javax.inject.Inject

class GetApiTokenUseCase @Inject constructor(
    private val userPreferences: UserPreferences
) {
    suspend operator fun invoke() {
        userPreferences.setApiToken(Constants.API_TOKEN)
    }
}