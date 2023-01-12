package com.example.applaudoscodechallengeandroid.localdatasource

import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel

interface LocalRepository {

    suspend fun getTvShows(): List<TvShowCacheModel>
    suspend fun getTvShow(id: String): TvShowCacheModel

    suspend fun setTvShows(tvShowsCache: List<TvShowCacheModel>): List<Long>
    suspend fun setTvShow(tvShowCacheModel: TvShowCacheModel): Long

}