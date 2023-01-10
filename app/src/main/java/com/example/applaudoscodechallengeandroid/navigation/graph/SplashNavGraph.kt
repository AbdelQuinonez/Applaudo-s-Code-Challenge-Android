package com.example.applaudoscodechallengeandroid.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.Navigation
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.applaudoscodechallengeandroid.navigation.NavigationDestinations

fun NavGraphBuilder.splashNavGraph(navController: NavController) {
    navigation (
        startDestination = NavigationDestinations.SPLASHSCREEN_SCREEN,
        route = NavigationDestinations.SPLASHSCREEN_ROUTE){

        composable(NavigationDestinations.SPLASHSCREEN_SCREEN) {
            TODO("Add splash screen route")
        }
    }
}