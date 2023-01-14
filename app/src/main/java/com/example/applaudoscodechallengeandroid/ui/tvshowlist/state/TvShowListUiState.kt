package com.example.applaudoscodechallengeandroid.ui.tvshowlist.state

import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel

data class TvShowListUiState(
    val loading : Boolean = false,
    val tvShowDomainModelList: List<TvShowDomainModel> = listOf()
)