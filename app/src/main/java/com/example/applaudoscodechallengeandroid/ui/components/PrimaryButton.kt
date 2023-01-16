package com.example.applaudoscodechallengeandroid.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applaudoscodechallengeandroid.R
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosCodeChallengeAndroidTheme
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosShapes
import com.example.applaudoscodechallengeandroid.ui.theme.WHITE
import com.example.applaudoscodechallengeandroid.utils.TestConstants.PRIMARY_BUTTON_TEST_TAG
import com.example.applaudoscodechallengeandroid.utils.TestConstants.TEXT_TEST


@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {

    Button(
        onClick = onClick,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
        ),
        shape = ApplaudosShapes.small,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = WHITE,
        ),
        modifier = modifier
            .testTag(PRIMARY_BUTTON_TEST_TAG)
            .defaultMinSize(
                minHeight = dimensionResource(R.dimen.btn_height)
            )
    ) {
        Text(
            text = text.uppercase(),
            style = MaterialTheme.typography.button,
        )
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewPrimaryButton() {
    ApplaudosCodeChallengeAndroidTheme {
        Row {
            PrimaryButton(
                text = TEXT_TEST,
                onClick = {},
            )
        }
    }
}