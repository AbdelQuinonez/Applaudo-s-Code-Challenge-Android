package com.example.applaudoscodechallengeandroid.data

import com.example.applaudoscodechallengeandroid.localdatasource.LocalRepository
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowSeasonCacheModel

class TestLocalRepository : LocalRepository {

    override suspend fun getTvShows(): List<TvShowCacheModel> =
        tvShowCacheModelList

    override suspend fun getTvShow(id: Int): TvShowCacheModel =
        tvShowCacheModel

    override suspend fun getTvShowSeasons(tvId: Int): List<TvShowSeasonCacheModel> =
        tvSeasonCacheModelList

    override suspend fun setTvShows(tvShowsCache: List<TvShowCacheModel>): List<Long> =
        longList

    override suspend fun setTvShow(tvShowCacheModel: TvShowCacheModel): Long =
        Math.random().toLong()

    override suspend fun setTvShowSeasons(tvShowSeasonCacheModelList: List<TvShowSeasonCacheModel>): List<Long> =
        longList


    companion object {

        val tvShowCacheModelList = listOf(
            TvShowCacheModel(
                id = Math.random().toInt(),
                posterPath = "google.com",
                popularity = 10.0,
                overview = "popularity",
                name = "got",
                originalName = "originalname",
                voteAverage = 10.0
            ),
            TvShowCacheModel(
                id = Math.random().toInt(),
                posterPath = "darkgoogle.com",
                popularity = 11.0,
                overview = "name",
                name = "overview",
                originalName = "average",
                voteAverage = 12.0
            )
        )

        val tvSeasonCacheModelList = listOf(
            TvShowSeasonCacheModel(
                id = Math.random().toInt(),
                tvId = 50,
                name = "season",
                overview = "overviewSeason",
                posterPath = "posterPath",
                seasonNumber = 0,
                episodeCount = 5
            ),
            TvShowSeasonCacheModel(
                id = Math.random().toInt(),
                tvId = 60,
                name = "seasonlist",
                overview = "overviewSeasonlist",
                posterPath = "posterPathlist",
                seasonNumber = 0,
                episodeCount = 5
            )
        )

        val tvShowCacheModel = TvShowCacheModel(
            id = Math.random().toInt(),
            posterPath = "google.com",
            popularity = 10.0,
            overview = "popularity",
            name = "got",
            originalName = "originalname",
            voteAverage = 10.0
        )

        val longList = listOf(
            Math.random().toLong(),
            Math.random().toLong(),
            Math.random().toLong(),
            -1
        )

    }
}