package com.example.applaudoscodechallengeandroid.remotedatasource.api

import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowDetailsResponseModel
import com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel.TvShowsResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface TvShowService {


    /*
    I didn't find any route that will retrieve all the data from a single request
    If I had added all the routes, a lot of data would have been repeated
    Of course that we have OnConflictStrategy.REPLACE, but what about the users Cellular Data / Battery
    A Zip() with all the routes could have been added into the RemoteDataSource if the client request it on this way
     */

    @GET("/3/tv/on_the_air")
    suspend fun getOnTheAirTvShows(): TvShowsResponseModel

    @GET("/3/tv/{tv_id}")
    suspend fun getTvShowDetails(@Path("tv_id") tvId: Int): TvShowDetailsResponseModel

}