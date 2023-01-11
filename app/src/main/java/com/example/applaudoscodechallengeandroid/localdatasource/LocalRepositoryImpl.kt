package com.example.applaudoscodechallengeandroid.localdatasource

import com.example.applaudoscodechallengeandroid.localdatasource.database.daos.TvShowDao
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCache
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val tvShowDao: TvShowDao
) : LocalRepository {

    override suspend fun getTvShows(): List<TvShowCache> =
        tvShowDao.getAll()

    override suspend fun getTvShow(id: String): TvShowCache =
        tvShowDao.getTvShow(id)

    override suspend fun setTvShows(tvShowsCache: List<TvShowCache>): List<Long> =
        tvShowDao.insertAll(tvShowsCache)

    override suspend fun setTvShow(tvShowCache: TvShowCache): Long =
        tvShowDao.insert(tvShowCache)

}