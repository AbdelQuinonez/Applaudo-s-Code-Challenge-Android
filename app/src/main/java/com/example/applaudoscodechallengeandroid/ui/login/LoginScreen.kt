package com.example.applaudoscodechallengeandroid.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.applaudoscodechallengeandroid.R
import com.example.applaudoscodechallengeandroid.ui.components.PrimaryButton
import com.example.applaudoscodechallengeandroid.ui.login.state.LoginViewModel
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosTypography
import com.example.applaudoscodechallengeandroid.ui.theme.TEXT
import com.example.applaudoscodechallengeandroid.ui.utils.Constants

@Composable
fun LoginRoute(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    LoginScreen(
        {}
    )
}

@Composable
fun LoginScreen(
    onLogin: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .padding(
                start = dimensionResource(R.dimen.default_screen_margin),
                end = dimensionResource(R.dimen.default_screen_margin),
            ),
        verticalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.login_screen_margin_between_components),
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginImage(
            imagePainter = painterResource(
                id =
                R.drawable.ic_login_logo
            )
        )

        Text(
            text = stringResource(R.string.login_screen_sing_in),
            style = ApplaudosTypography.body1,
            color = TEXT
        )

        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.login_screen_log_in_button),
            onClick = onLogin
        )
    }

}

@Composable
fun LoginImage(
    modifier: Modifier = Modifier,
    imagePainter: Painter,
) {
    Image(
        painter = imagePainter,
        contentDescription = Constants.CONTENT_DESCRIPTION_IMAGE_LOGIN_SCREEN,
        modifier = modifier
    )
}

