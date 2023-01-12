package com.example.applaudoscodechallengeandroid.remotedatasource.datasource

import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowDetailsResponseModel
import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowsResponseModel

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): TvShowsResponseModel
    suspend fun getTvShowDetails(tvId: String): TvShowDetailsResponseModel

}