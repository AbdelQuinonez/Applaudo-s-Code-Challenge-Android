package com.example.applaudoscodechallengeandroid.ui.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applaudoscodechallengeandroid.domain.interactors.GetApiTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val getApiTokenUseCase: GetApiTokenUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            getApiTokenUseCase()
        }
    }

}