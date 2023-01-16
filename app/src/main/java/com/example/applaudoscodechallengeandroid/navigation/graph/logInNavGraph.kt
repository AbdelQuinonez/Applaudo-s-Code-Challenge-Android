package com.example.applaudoscodechallengeandroid.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.applaudoscodechallengeandroid.navigation.NavigationDestinations
import com.example.applaudoscodechallengeandroid.ui.login.LoginRoute

fun NavGraphBuilder.logInNavGraph(navController: NavController) {
    navigation(
        startDestination = NavigationDestinations.LOG_IN_SCREEN,
        route = NavigationDestinations.LOG_IN_ROUTE
    ) {

        composable(NavigationDestinations.LOG_IN_SCREEN) {
            LoginRoute(navController = navController)
        }
    }
}