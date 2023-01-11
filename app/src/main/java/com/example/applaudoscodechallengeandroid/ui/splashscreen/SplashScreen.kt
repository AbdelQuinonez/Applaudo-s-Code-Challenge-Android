package com.example.applaudoscodechallengeandroid.ui.splashscreen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.applaudoscodechallengeandroid.R
import com.example.applaudoscodechallengeandroid.navigation.NavigationDestinations
import com.example.applaudoscodechallengeandroid.ui.theme.GRADIENT
import com.example.applaudoscodechallengeandroid.ui.theme.tertiarySecondaryVariant
import com.example.applaudoscodechallengeandroid.utils.Constants.CONTENT_DESCRIPTION_IMAGE_SPLASH_SCREEN
import com.example.applaudoscodechallengeandroid.utils.Constants.RECOMMENDED_ANIMATION_DURATION
import com.example.applaudoscodechallengeandroid.utils.Constants.SPLASH_SCREEN_DELAY_DURATION
import kotlinx.coroutines.delay

@Composable
fun SplashRoute(
    navController: NavController,
) {
    SplashScreen(
        navController = navController,
    )
}

@Composable
fun SplashScreen(
    navController: NavController,
) {

    val scaleAnimation: Animatable<Float, AnimationVector1D> =
        remember { Animatable(initialValue = 0f) }

    AnimationSplashContent(
        scaleAnimation = scaleAnimation,
        navController = navController,
        durationMillisAnimation = RECOMMENDED_ANIMATION_DURATION,
        delayScreen = SPLASH_SCREEN_DELAY_DURATION
    )

    SplashScreenContent(
        imagePainter = painterResource(
            id =
            R.drawable.ic_splash_logo
        ),
        scaleAnimation = scaleAnimation
    )

}

@Composable
fun AnimationSplashContent(
    scaleAnimation: Animatable<Float, AnimationVector1D>,
    navController: NavController,
    durationMillisAnimation: Int,
    delayScreen: Long
) {

    LaunchedEffect(key1 = true) {
        scaleAnimation.animateTo(
            targetValue = 0.5F,
            animationSpec = tween(
                durationMillis = durationMillisAnimation,
                easing = {
                    OvershootInterpolator(3F).getInterpolation(it)
                }
            )
        )

        delay(timeMillis = delayScreen)

        navController.navigate(route = NavigationDestinations.LOG_IN_ROUTE)
    }
}

@Composable
fun SplashScreenContent(
    modifier: Modifier = Modifier,
    imagePainter: Painter,
    scaleAnimation: Animatable<Float, AnimationVector1D>
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        tertiarySecondaryVariant,
                        //Double to simulate the same image from figma
                        GRADIENT,
                        GRADIENT,
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = imagePainter,
            contentDescription = CONTENT_DESCRIPTION_IMAGE_SPLASH_SCREEN,
            modifier = modifier
                .size(400.dp)
                .scale(scale = scaleAnimation.value),
        )
    }
}