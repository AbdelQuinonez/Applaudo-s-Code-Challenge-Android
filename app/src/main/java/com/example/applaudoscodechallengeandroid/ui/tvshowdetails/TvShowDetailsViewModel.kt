package com.example.applaudoscodechallengeandroid.ui.tvshowdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applaudoscodechallengeandroid.core.successOr
import com.example.applaudoscodechallengeandroid.domain.interactors.GetTvShowDetailsUseCase
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.ui.tvshowdetails.state.TvShowDetailsUiState
import com.example.applaudoscodechallengeandroid.ui.utils.Constants.INVALID_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowDetailsViewModel @Inject constructor(
    val getTvShowDetailsUseCase: GetTvShowDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TvShowDetailsUiState())

    val uiState: StateFlow<TvShowDetailsUiState> = _uiState

    private var tvId: Int = INVALID_ID

    fun setTvId(tvId: Int) {
        this.tvId = tvId
        getTvShowWithSeasons()
    }

    fun getTvId(): Int {
        return tvId
    }

    private fun getTvShowWithSeasons() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    loading = true
                )
            }

            val response = getTvShowDetailsUseCase(tvId)
            val tvShowDetailDomainModel = response.successOr(TvShowDomainModel())

            _uiState.update {
                it.copy(
                    loading = false,
                    tvShowDomainModel = tvShowDetailDomainModel
                )
            }
        }
    }

}