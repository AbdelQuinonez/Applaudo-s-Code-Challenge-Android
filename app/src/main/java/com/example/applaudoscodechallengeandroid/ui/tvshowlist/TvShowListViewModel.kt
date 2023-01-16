package com.example.applaudoscodechallengeandroid.ui.tvshowlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applaudoscodechallengeandroid.core.successOr
import com.example.applaudoscodechallengeandroid.domain.interactors.GetTvShowsUseCase
import com.example.applaudoscodechallengeandroid.domain.model.getSortBy
import com.example.applaudoscodechallengeandroid.ui.tvshowlist.state.TvShowListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowListViewModel @Inject constructor(
    val getTvShowsUseCase: GetTvShowsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TvShowListUiState())

    val uiState: StateFlow<TvShowListUiState> = _uiState

    init {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    loading = true
                )
            }
            getTvShowList()
        }
    }

    private fun getTvShowList() {
        viewModelScope.launch {

            val response = getTvShowsUseCase()
            val tvShowModelList = response.successOr(listOf())

            _uiState.update {
                it.copy(
                    loading = false,
                    tvShowDomainModelList = tvShowModelList
                )
            }

        }
    }

    fun sortBy(value : String){

        _uiState.update {
            it.copy(
                loading = true
            )
        }

        //sort list and update the uiState

        _uiState.update {
            it.copy(
                loading = false,
                sortBy = getSortBy(value)
            )
        }

    }


}