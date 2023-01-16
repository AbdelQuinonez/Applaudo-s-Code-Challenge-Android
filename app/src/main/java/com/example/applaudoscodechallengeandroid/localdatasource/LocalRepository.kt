package com.example.applaudoscodechallengeandroid.localdatasource

import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowSeasonCacheModel

interface LocalRepository {

    suspend fun getTvShows(): List<TvShowCacheModel>
    suspend fun getTvShow(id: Int): TvShowCacheModel
    suspend fun getTvShowSeasons(tvId: Int): List<TvShowSeasonCacheModel>

    suspend fun setTvShows(tvShowsCache: List<TvShowCacheModel>): List<Long>
    suspend fun setTvShow(tvShowCacheModel: TvShowCacheModel): Long
    suspend fun setTvShowSeasons(tvShowSeasonCacheModelList: List<TvShowSeasonCacheModel>): List<Long>

}