package com.example.applaudoscodechallengeandroid.utils

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.applaudoscodechallengeandroid.utils.Constants.EMPTY_STRING
import com.example.applaudoscodechallengeandroid.utils.Constants.GO_BACK_AND_REFRESH
import com.example.applaudoscodechallengeandroid.utils.Constants.REFRESH

fun NavHostController.navigateTo(screenRoute: String) {
    this.navigate(screenRoute) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(this@navigateTo.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}

fun NavHostController.shouldRefreshScreen(): Boolean {
    if (this.currentBackStackEntry?.savedStateHandle?.contains(GO_BACK_AND_REFRESH) == true) {
        val keyData = this.currentBackStackEntry?.savedStateHandle?.get<String>(
            GO_BACK_AND_REFRESH
        ) ?: EMPTY_STRING

        if (keyData == REFRESH)
            return true
    }
    return false
}

fun NavHostController.removeRefresh() {
    this.currentBackStackEntry?.savedStateHandle?.remove<String>(GO_BACK_AND_REFRESH)
}