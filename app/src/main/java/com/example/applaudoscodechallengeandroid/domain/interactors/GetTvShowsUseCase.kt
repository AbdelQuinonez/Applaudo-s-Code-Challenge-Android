package com.example.applaudoscodechallengeandroid.domain.interactors

import com.example.applaudoscodechallengeandroid.localdatasource.LocalRepository
import com.example.applaudoscodechallengeandroid.localdatasource.database.daos.TvShowDao
import com.example.applaudoscodechallengeandroid.remotedatasource.datasource.TvShowRemoteDataSource
import com.example.applaudoscodechallengeandroid.utils.NetworkApi
import javax.inject.Inject

class GetTvShowsUseCase @Inject constructor(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val localRepository: LocalRepository,
    private val networkApi: NetworkApi
) {

    suspend operator fun invoke(){
        if(networkApi.isNetworkAvailable()){

        }
    }

    private fun getCacheData(){

    }

}