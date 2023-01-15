package com.example.applaudoscodechallengeandroid.localdatasource

import com.example.applaudoscodechallengeandroid.localdatasource.database.daos.TvShowDao
import com.example.applaudoscodechallengeandroid.localdatasource.database.daos.TvShowSeasonDao
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowSeasonCacheModel
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val tvShowDao: TvShowDao,
    private val tvShowSeasonDao: TvShowSeasonDao
) : LocalRepository {

    override suspend fun getTvShows(): List<TvShowCacheModel> =
        tvShowDao.getAll()

    override suspend fun getTvShow(id: Int): TvShowCacheModel =
        tvShowDao.getTvShow(id)

    override suspend fun getTvShowSeasons(tvId: Int): List<TvShowSeasonCacheModel> =
        tvShowSeasonDao.getAll(tvId)

    override suspend fun setTvShows(tvShowsCache: List<TvShowCacheModel>): List<Long> =
        tvShowDao.insertAll(tvShowsCache)

    override suspend fun setTvShow(tvShowCacheModel: TvShowCacheModel): Long =
        tvShowDao.insert(tvShowCacheModel)

    override suspend fun setTvShowSeasons(tvShowSeasonCacheModelList: List<TvShowSeasonCacheModel>): List<Long> =
        tvShowSeasonDao.insertAll(tvShowSeasonCacheModelList)


}