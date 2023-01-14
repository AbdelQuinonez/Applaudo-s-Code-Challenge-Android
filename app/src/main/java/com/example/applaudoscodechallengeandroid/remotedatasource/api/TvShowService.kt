package com.example.applaudoscodechallengeandroid.remotedatasource.api

import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowDetailsResponseModel
import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowsResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface TvShowService {

    @GET("/3/tv/on_the_air")
    suspend fun getTvShows(): TvShowsResponseModel

    @GET("/3/tv/{tv_id}")
    suspend fun getTvShowDetails(@Path("tv_id") tvId: String): TvShowDetailsResponseModel

}