package com.example

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.applaudoscodechallengeandroid.navigation.MainNavigation
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosCodeChallengeAndroidTheme

@Composable
fun ApplaudosApp() {
    ApplaudosCodeChallengeAndroidTheme {
        val navController = rememberNavController()
        Scaffold(
            content = { padding ->
                MainNavigation(
                    navController = navController,
                    modifier = Modifier.padding(padding)
                )
            })
    }
}