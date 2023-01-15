package com.example.applaudoscodechallengeandroid.remotedatasource.api

import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowDetailsResponseModel
import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowsResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface TvShowService {

    @GET("/3/tv/airing_today")
    suspend fun getAiringTodayTvShows(): TvShowsResponseModel

    @GET("/3/tv/on_the_air")
    suspend fun getOnTheAirTvShows(): TvShowsResponseModel

    @GET("/3/tv/popular")
    suspend fun getPopularTvShows(): TvShowsResponseModel

    @GET("/3/tv/top_rated")
    suspend fun getTopRatedTvShows(): TvShowsResponseModel

    @GET("/3/tv/{tv_id}")
    suspend fun getTvShowDetails(@Path("tv_id") tvId: Int): TvShowDetailsResponseModel

}