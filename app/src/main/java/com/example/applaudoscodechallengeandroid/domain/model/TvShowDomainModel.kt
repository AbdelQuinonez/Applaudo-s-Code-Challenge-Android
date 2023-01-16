package com.example.applaudoscodechallengeandroid.domain.model

data class TvShowDomainModel(
    val id: Int = 0,
    val name: String = "",
    val originalName: String = "",
    val posterPath: String = "",
    val popularity: Double = 0.0,
    val voteAverage: Double = 0.0,
    val overview: String = "",
    val seasons: List<TvShowSeasonDomainModel> = listOf()
)
