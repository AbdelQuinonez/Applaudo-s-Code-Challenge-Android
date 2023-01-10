package com.example.applaudoscodechallengeandroid.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    secondary = secondaryColor,
    background = BACKGROUND,
    error = ERROR,
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    secondary = secondaryColor,
    background = BACKGROUND,
    error = ERROR
)

@Composable
fun ApplaudosCodeChallengeAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}