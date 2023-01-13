package com.example.applaudoscodechallengeandroid.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .testTag(TV_SHOW_TEST_TAG),
            shape = RoundedCornerShape(dimensionResource(R.dimen.default_card_corner_radius)),
        ) {
            Column(Modifier.padding(top = 7.33.dp, start = 4.dp, end = 4.dp, bottom = 4.dp)) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = tvShowDomainModel.posterPath,
                        error = painterResource(R.drawable.ic_no_image)
                    ),
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .widthIn(min = 128.dp, max = 128.dp)
                        .heightIn(min = 77.dp, max = 77.dp)
                )

                Text(
                    modifier = Modifier
                        .padding(8.dp),
                    text = tvShowDomainModel.name,
                    style = ApplaudosTypography.subtitle2,
                    color = TEXT,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
        }
    }
}


@Composable
fun paintStars(voteAverage:Double){
    Row(

    ){

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