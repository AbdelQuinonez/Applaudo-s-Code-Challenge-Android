package com.example.applaudoscodechallengeandroid.remotedatasource.datasource

import com.example.applaudoscodechallengeandroid.remotedatasource.api.TvShowService
import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowDetailsResponseModel
import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowsResponseModel
import javax.inject.Inject

class TvShowRemoteDataSourceImpl @Inject constructor(
    private val tvShowService: TvShowService
) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): TvShowsResponseModel =
        tvShowService.getOnTheAirTvShows()


    override suspend fun getTvShowDetails(tvId: String): TvShowDetailsResponseModel =
        tvShowService.getTvShowDetails(tvId)

}