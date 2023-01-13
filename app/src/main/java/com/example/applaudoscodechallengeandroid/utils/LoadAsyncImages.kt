package com.example.applaudoscodechallengeandroid.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.applaudoscodechallengeandroid.R

@Composable
fun LoadAsyncImages(
    remoteResource: String,
): Painter {
    val remoteImagePainter = rememberAsyncImagePainter(
        model = remoteResource,
        error = painterResource(R.drawable.ic_no_image)
    )
    val isErrorState = when (remoteImagePainter.state) {
        is AsyncImagePainter.State.Error,
        is AsyncImagePainter.State.Loading,
        -> true
        else -> false
    }
    return remoteImagePainter
}