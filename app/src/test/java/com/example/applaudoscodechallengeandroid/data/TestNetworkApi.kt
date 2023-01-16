package com.example.applaudoscodechallengeandroid.data

import com.example.applaudoscodechallengeandroid.ui.utils.NetworkApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestNetworkApi : NetworkApi {
    override fun isNetworkAvailable(): Boolean =
        true

    override fun isWifiEnabled(): Boolean =
        true

    override fun isMobileNetworkEnabled(): Boolean =
        true

    override fun connectivityStatus(): Flow<NetworkApi.Status> =
        flow {
            emit(NetworkApi.Status.Available)
        }


}