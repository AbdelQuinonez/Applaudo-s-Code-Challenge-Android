package com.example.applaudoscodechallengeandroid.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.applaudoscodechallengeandroid.navigation.NavigationDestinations
import com.example.applaudoscodechallengeandroid.ui.splashscreen.SplashRoute

fun NavGraphBuilder.splashNavGraph(navController: NavController) {
    navigation (
        startDestination = NavigationDestinations.SPLASHSCREEN_SCREEN,
        route = NavigationDestinations.SPLASHSCREEN_ROUTE){

        composable(NavigationDestinations.SPLASHSCREEN_SCREEN) {
            SplashRoute(navController = navController)
        }
    }
}