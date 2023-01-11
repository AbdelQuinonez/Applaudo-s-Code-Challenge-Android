package com.example.applaudoscodechallengeandroid.localdatasource

import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCache
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    suspend fun getTvShows(): List<TvShowCache>
    suspend fun getTvShow(id: String): TvShowCache

    suspend fun setTvShows(tvShowsCache: List<TvShowCache>): List<Long>
    suspend fun setTvShow(tvShowCache: TvShowCache): Long

}