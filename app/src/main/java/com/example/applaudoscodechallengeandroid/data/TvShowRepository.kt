package com.example.applaudoscodechallengeandroid.data

import com.example.applaudoscodechallengeandroid.core.DataState
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowDetailsCacheModel

interface TvShowRepository {
    suspend fun getTvShows(): DataState<List<TvShowCacheModel>>
    suspend fun getTvShowDetails(tvId:String): DataState<TvShowDetailsCacheModel>
}