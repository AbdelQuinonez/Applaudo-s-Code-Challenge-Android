package com.example.applaudoscodechallengeandroid.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.applaudoscodechallengeandroid.BuildConfig
import com.example.applaudoscodechallengeandroid.R
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosCodeChallengeAndroidTheme
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosTypography
import com.example.applaudoscodechallengeandroid.ui.theme.TEXT
import com.example.applaudoscodechallengeandroid.utils.Constants.EMPTY_STRING
import com.example.applaudoscodechallengeandroid.utils.Constants.NO_IMAGE_RESOURCE
import com.example.applaudoscodechallengeandroid.utils.TestConstants.TV_SHOW_NAME
import com.example.applaudoscodechallengeandroid.utils.TestConstants.TV_SHOW_POSTER_PATH
import com.example.applaudoscodechallengeandroid.utils.TestConstants.TV_SHOW_TEST_TAG
import com.example.applaudoscodechallengeandroid.utils.TestConstants.VOTE_AVERAGE

@Composable
fun TvShowComposable(
    modifier: Modifier = Modifier,
    tvShowDomainModel: TvShowDomainModel,
    onClick: () -> Unit,
    contentDescription: String = EMPTY_STRING,
    @DrawableRes localResource: Int = NO_IMAGE_RESOURCE,
) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        elevation = dimensionResource(id = R.dimen.tv_show_component_elevation),
        shape = RoundedCornerShape(dimensionResource(R.dimen.default_card_corner_radius))
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .testTag(TV_SHOW_TEST_TAG),
        ) {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = BuildConfig.BASE_IMAGE_URL + tvShowDomainModel.posterPath,
                        error = painterResource(R.drawable.ic_no_image)
                    ),
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .widthIn(
                            min = dimensionResource(id = R.dimen.tv_show_component_image_min_width_size),
                            max = dimensionResource(id = R.dimen.tv_show_component_image_min_width_size)
                        )
                        .heightIn(
                            min = dimensionResource(id = R.dimen.tv_show_component_image_min_height_size),
                            max = dimensionResource(id = R.dimen.tv_show_component_image_min_height_size)
                        ),
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.tv_show_component_start_padding),
                            top = dimensionResource(id = R.dimen.tv_show_component_top_bottom_padding),
                            end = dimensionResource(id = R.dimen.tv_show_component_start_padding),
                        ),
                    text = tvShowDomainModel.name,
                    style = ApplaudosTypography.subtitle2,
                    color = TEXT,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )

                Row(
                    Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.tv_show_component_start_padding),
                            end = dimensionResource(id = R.dimen.tv_show_component_start_padding),
                            bottom = dimensionResource(id = R.dimen.tv_show_component_top_bottom_padding)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RatingBar(
                        rating = tvShowDomainModel.voteAverage.toFloat(),
                        spaceBetween = 4.dp
                    )
                    Text(
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.tv_show_component_start_text_padding)),
                        text = tvShowDomainModel.voteAverage.toString(),
                        style = ApplaudosTypography.body2,
                        color = TEXT
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewTvShowComposable() {
    ApplaudosCodeChallengeAndroidTheme {
        TvShowComposable(
            tvShowDomainModel = TvShowDomainModel(
                name = TV_SHOW_NAME,
                posterPath = TV_SHOW_POSTER_PATH,
                voteAverage = VOTE_AVERAGE
            ),
            onClick = {}
        )
    }
}