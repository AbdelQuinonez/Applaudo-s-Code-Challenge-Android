package com.example.applaudoscodechallengeandroid.domain.interactors

import com.example.applaudoscodechallengeandroid.core.DataState
import com.example.applaudoscodechallengeandroid.core.ErrorHandling
import com.example.applaudoscodechallengeandroid.core.successOr
import com.example.applaudoscodechallengeandroid.data.TvShowRepository
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.localdatasource.LocalRepository
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowDetailsCacheModel
import com.example.applaudoscodechallengeandroid.utils.NetworkApi
import javax.inject.Inject

class GetTvShowDetailsUseCase @Inject constructor(
    private val tvShowRepository: TvShowRepository,
    private val localRepository: LocalRepository,
    private val networkApi: NetworkApi
) {

    suspend operator fun invoke(tvId: Int): DataState<TvShowDomainModel> {

        if (networkApi.isNetworkAvailable()) {
            val dataState = tvShowRepository.getTvShowDetails(tvId)
            val response = dataState.successOr(TvShowDetailsCacheModel())
            localRepository.setTvShowSeasons(response.seasons)
        }

        return try {
            val noSeasonsTvShowDomainModel = localRepository.getTvShow(tvId).mapFromCacheToDomain()
            val tvShowSeasonCacheModelList = localRepository.getTvShowSeasons(tvId)
            val tvShowDomainModel = noSeasonsTvShowDomainModel.copy(
                seasons = List(tvShowSeasonCacheModelList.size) { i ->
                    tvShowSeasonCacheModelList[i].mapFromCacheToDomainModel()
                }
            )
            DataState.success(tvShowDomainModel)
        } catch (e: Exception) {
            val errorModel = ErrorHandling.handleError(e)
            DataState.failure(errorModel)
        }

    }

}