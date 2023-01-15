package com.example.applaudoscodechallengeandroid.data

import com.example.applaudoscodechallengeandroid.core.DataState
import com.example.applaudoscodechallengeandroid.core.ErrorHandling
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowDetailsCacheModel
import com.example.applaudoscodechallengeandroid.remotedatasource.datasource.TvShowRemoteDataSource
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource
): TvShowRepository

    {
    override suspend fun getTvShows(): DataState<List<TvShowCacheModel>> {
        return try{
            val tvShowCacheModelList = tvShowRemoteDataSource.getTvShows().mapFromRemoteToCacheModel()
            DataState.success(tvShowCacheModelList)
        } catch ( e: Exception){
            val errorModel = ErrorHandling.handleError(e)
            DataState.failure(errorModel)
        }
    }

    override suspend fun getTvShowDetails(tvId: Int): DataState<TvShowDetailsCacheModel> {
        return try{
            val tvShowDetailsCacheModel = tvShowRemoteDataSource.getTvShowDetails(tvId).mapFromRemoteToDomainModel()
            DataState.success(tvShowDetailsCacheModel)
        } catch ( e: Exception){
            val errorModel = ErrorHandling.handleError(e)
            DataState.failure(errorModel)
        }
    }

}