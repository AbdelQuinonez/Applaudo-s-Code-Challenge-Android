package com.example.applaudoscodechallengeandroid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.rememberAsyncImagePainter
import com.example.applaudoscodechallengeandroid.BuildConfig
import com.example.applaudoscodechallengeandroid.R
import com.example.applaudoscodechallengeandroid.domain.model.TvShowSeasonDomainModel
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosShapes
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosTypography
import com.example.applaudoscodechallengeandroid.ui.theme.TEXT
import com.example.applaudoscodechallengeandroid.ui.theme.primaryColor
import com.example.applaudoscodechallengeandroid.utils.Constants

@Composable
fun TvShowSeasonComponent(
    modifier: Modifier = Modifier,
    tvShowSeasonDomainModel: TvShowSeasonDomainModel,
    contentDescription: String = Constants.EMPTY_STRING,
) {
    Surface(
        modifier = modifier
            .fillMaxSize(),
        elevation = dimensionResource(id = R.dimen.tv_show_season_component_elevation),
        shape = ApplaudosShapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = BuildConfig.BASE_IMAGE_URL + tvShowSeasonDomainModel.posterPath,
                    error = painterResource(R.drawable.ic_no_image),
                    placeholder = painterResource(id = R.drawable.ic_downloading)
                ),
                contentDescription = contentDescription,
                modifier = Modifier
                    .widthIn(
                        min = dimensionResource(id = R.dimen.tv_show_season_component_image_min_width_size),
                        max = dimensionResource(id = R.dimen.tv_show_season_component_image_min_width_size)
                    )
                    .heightIn(
                        min = dimensionResource(id = R.dimen.tv_show_season_component_image_min_height_size),
                        max = dimensionResource(id = R.dimen.tv_show_season_component_image_min_height_size)
                    ),
                contentScale = ContentScale.FillBounds
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.default_screen_margin)),
            ) {
                Text(
                    text = tvShowSeasonDomainModel.name,
                    color = TEXT,
                    style = ApplaudosTypography.h6
                )
                //This font was different in figma, using Cabin as a font on his place I used sub2
                Text(
                    modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.tv_show_season_component_body_text_margin)),
                    text = stringResource(
                        id = R.string.tv_shows_season_episodes_number,
                        tvShowSeasonDomainModel.seasonNumber
                    ), color = primaryColor, style = ApplaudosTypography.subtitle2
                )
                Text(
                    text = tvShowSeasonDomainModel.overview,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3,
                    color = TEXT,
                    style = ApplaudosTypography.body2
                )
            }
        }
    }
}