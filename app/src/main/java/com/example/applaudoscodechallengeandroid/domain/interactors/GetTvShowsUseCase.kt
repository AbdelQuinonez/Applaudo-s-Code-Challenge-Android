package com.example.applaudoscodechallengeandroid.domain.interactors

import com.example.applaudoscodechallengeandroid.core.DataState
import com.example.applaudoscodechallengeandroid.core.ErrorHandling
import com.example.applaudoscodechallengeandroid.core.successOr
import com.example.applaudoscodechallengeandroid.data.TvShowRepository
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.localdatasource.LocalRepository
import com.example.applaudoscodechallengeandroid.ui.utils.NetworkApi
import javax.inject.Inject

class GetTvShowsUseCase @Inject constructor(
    private val tvShowRepository: TvShowRepository,
    private val localRepository: LocalRepository,
    private val networkApi: NetworkApi
) {

    suspend operator fun invoke(): DataState<List<TvShowDomainModel>> {

        if (networkApi.isNetworkAvailable()) {
            val dataState = tvShowRepository.getTvShows()
            val response = dataState.successOr(listOf())
            localRepository.setTvShows(response)
        }

        return try {
            val tvShowCacheModelList = localRepository.getTvShows()
            val tvShowDomainModelList = List(tvShowCacheModelList.size) { i ->
                tvShowCacheModelList[i].mapFromCacheToDomain()
            }
            DataState.success(tvShowDomainModelList)
        } catch (e: Exception) {
            val errorModel = ErrorHandling.handleError(e)
            DataState.failure(errorModel)
        }

    }


}