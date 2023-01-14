package com.example.applaudoscodechallengeandroid.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applaudoscodechallengeandroid.R
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosCodeChallengeAndroidTheme
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosShapes
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosTypography
import com.example.applaudoscodechallengeandroid.ui.theme.GRAY
import com.example.applaudoscodechallengeandroid.utils.TestConstants.TEXT_TEST

@Composable
fun SortChip(
    name: String,
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit,
) {
    Surface(
        modifier = Modifier.padding(),
        elevation = dimensionResource(id = R.dimen.sort_chip_elevation),
        shape = ApplaudosShapes.large,
        color = if (isSelected) MaterialTheme.colors.primary else GRAY
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            )
        ) {
            Text(
                text = name,
                style = ApplaudosTypography.subtitle2,
                color = Color.White,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.sort_chip_horizontal_padding),
                    vertical = dimensionResource(
                        id = R.dimen.sort_chip_vertical_padding
                    )
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewSortChip() {
    ApplaudosCodeChallengeAndroidTheme {
        SortChip(name = TEXT_TEST, onSelectionChanged = {})
    }
}