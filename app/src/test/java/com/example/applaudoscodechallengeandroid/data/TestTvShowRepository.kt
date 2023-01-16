package com.example.applaudoscodechallengeandroid.data

import androidx.datastore.preferences.core.preferencesOf
import com.example.applaudoscodechallengeandroid.core.DataState
import com.example.applaudoscodechallengeandroid.data.TvShowRepository
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowDetailsCacheModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowSeasonCacheModel

class TestTvShowRepository : TvShowRepository {

    override suspend fun getTvShows(): DataState<List<TvShowCacheModel>> =
        DataState.success(tvShowCacheModelList)

    override suspend fun getTvShowDetails(tvId: Int): DataState<TvShowDetailsCacheModel> =
        DataState.success(tvShowDetailCacheModel)

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

        val tvShowDetailCacheModel = TvShowDetailsCacheModel(
            id = Math.random().toInt(),
            posterPath = "google.com",
            popularity = 15.0,
            overview = "popularity",
            name = "got",
            originalName = "originalname",
            voteAverage = 10.0,
            seasons = listOf(
                TvShowSeasonCacheModel(
                    id = Math.random().toInt(),
                    tvId = 50,
                    name = "season",
                    overview = "overviewSeason",
                    posterPath = "posterPath",
                    seasonNumber = 0,
                    episodeCount = 5
                )
            )
        )
    }
}