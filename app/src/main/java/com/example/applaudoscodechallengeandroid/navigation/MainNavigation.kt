package com.example.applaudoscodechallengeandroid.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.applaudoscodechallengeandroid.navigation.graph.logInNavGraph
import com.example.applaudoscodechallengeandroid.navigation.graph.splashNavGraph


@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavigationDestinations.SPLASHSCREEN_ROUTE,
        modifier = modifier
    )
    {
        splashNavGraph(navController)
        logInNavGraph(navController)
    }
}