package com.example.applaudoscodechallengeandroid.localdatasource

import com.example.applaudoscodechallengeandroid.localdatasource.database.daos.TvShowDao
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val tvShowDao: TvShowDao
) : LocalRepository {

    override suspend fun getTvShows(): List<TvShowCacheModel> =
        tvShowDao.getAll()

    override suspend fun getTvShow(id: String): TvShowCacheModel =
        tvShowDao.getTvShow(id)

    override suspend fun setTvShows(tvShowsCache: List<TvShowCacheModel>): List<Long> =
        tvShowDao.insertAll(tvShowsCache)

    override suspend fun setTvShow(tvShowCacheModel: TvShowCacheModel): Long =
        tvShowDao.insert(tvShowCacheModel)

}