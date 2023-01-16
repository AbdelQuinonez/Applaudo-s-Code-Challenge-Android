package com.example.applaudoscodechallengeandroid.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.applaudoscodechallengeandroid.navigation.NavigationDestinations
import com.example.applaudoscodechallengeandroid.ui.tvshowdetails.TvShowDetailsRoute
import com.example.applaudoscodechallengeandroid.ui.utils.goBack

fun NavGraphBuilder.tvShowListNavGraph(navController: NavHostController) {

    navigation(
        startDestination = NavigationDestinations.TV_SHOW_DETAILS_ROUTE,
        route = NavigationDestinations.TV_SHOW_DETAILS_SCREEN
    ) {

        composable(route = "${NavigationDestinations.TV_SHOW_DETAILS_SCREEN}/{${NavigationDestinations.TV_ID}}") {

            val tvId = it.arguments?.getString(NavigationDestinations.TV_ID)?.toInt() ?: 0

            TvShowDetailsRoute(tvId = tvId, goBack = navController::goBack)

        }
    }

}