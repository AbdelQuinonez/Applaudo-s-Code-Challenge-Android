package com.example.applaudoscodechallengeandroid.ui.tvshowdetails.state

import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel

data class TvShowDetailsUiState(
    val loading: Boolean = false,
    val tvShowDomainModel: TvShowDomainModel = TvShowDomainModel()
)