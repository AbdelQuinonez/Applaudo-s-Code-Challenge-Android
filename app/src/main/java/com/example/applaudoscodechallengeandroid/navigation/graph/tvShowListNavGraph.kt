package com.example.applaudoscodechallengeandroid.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.applaudoscodechallengeandroid.navigation.NavigationDestinations
import com.example.applaudoscodechallengeandroid.ui.splashscreen.SplashRoute
import com.example.applaudoscodechallengeandroid.utils.removeRefresh
import com.example.applaudoscodechallengeandroid.utils.shouldRefreshScreen

fun NavGraphBuilder.tvShowListNavGraph(navController: NavHostController) {

    navigation (
        startDestination = NavigationDestinations.TV_SHOW_LIST_SCREEN,
        route = NavigationDestinations.TV_SHOW_LIST_ROUTE){

        composable(route ="${NavigationDestinations.TV_SHOW_DETAILS_SCREEN}/{${NavigationDestinations.TV_SHOW_ID}}") {

            val tvShowId = it.arguments?.getInt(NavigationDestinations.TV_SHOW_ID)
            val shouldRefreshScreen = navController.shouldRefreshScreen()

            TODO("create and open tv show detail screen")

            navController.removeRefresh()
        }
    }

}