package com.example.applaudoscodechallengeandroid.local_datasource

import com.example.applaudoscodechallengeandroid.local_datasource.database.model.TvShowCache
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    suspend fun getTvShows(): Flow<List<TvShowCache>>
    suspend fun getTvShow(id: String): Flow<TvShowCache>

    suspend fun setTvShows(tvShows: List<TvShowCache>): Flow<List<Long>>
    suspend fun setTvShow(tvShow:TvShowCache): Flow<Long>

}