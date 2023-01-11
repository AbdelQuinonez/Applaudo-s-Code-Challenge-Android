package com.example.applaudoscodechallengeandroid.local_datasource

import com.example.applaudoscodechallengeandroid.local_datasource.database.daos.TvShowDao
import com.example.applaudoscodechallengeandroid.local_datasource.database.model.TvShowCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val tvShowDao: TvShowDao
) : LocalRepository {

    override suspend fun getTvShows(): Flow<List<TvShowCache>> =
        tvShowDao.getAll()

    override suspend fun getTvShow(id: String): Flow<TvShowCache> =
        tvShowDao.getTvShow(id)

    override suspend fun setTvShows(tvShows: List<TvShowCache>): Flow<List<Long>> =
        tvShowDao.insertAll(tvShows)

    override suspend fun setTvShow(tvShow: TvShowCache): Flow<Long> =
        tvShowDao.insert(tvShow)

}