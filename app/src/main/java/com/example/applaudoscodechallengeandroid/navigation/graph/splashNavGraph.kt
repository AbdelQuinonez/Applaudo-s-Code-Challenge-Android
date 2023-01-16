package com.example.applaudoscodechallengeandroid.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.applaudoscodechallengeandroid.navigation.NavigationDestinations
import com.example.applaudoscodechallengeandroid.ui.splashscreen.SplashRoute
import com.example.applaudoscodechallengeandroid.ui.tvshowlist.TvShowListRoute
import com.example.applaudoscodechallengeandroid.utils.navigateTo

fun NavGraphBuilder.splashNavGraph(navController: NavHostController) {
    navigation (
        startDestination = NavigationDestinations.SPLASHSCREEN_SCREEN,
        route = NavigationDestinations.SPLASHSCREEN_ROUTE){

        composable(NavigationDestinations.SPLASHSCREEN_SCREEN) {
            SplashRoute(navController)
        }

        composable(NavigationDestinations.TV_SHOW_LIST_ROUTE) {
            TvShowListRoute(navController::navigateTo)
        }
    }
}