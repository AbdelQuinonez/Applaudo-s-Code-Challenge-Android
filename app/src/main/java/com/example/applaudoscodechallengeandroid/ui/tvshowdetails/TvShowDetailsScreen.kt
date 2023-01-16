package com.example.applaudoscodechallengeandroid.ui.tvshowdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.applaudoscodechallengeandroid.BuildConfig
import com.example.applaudoscodechallengeandroid.R
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.domain.model.TvShowSeasonDomainModel
import com.example.applaudoscodechallengeandroid.ui.components.RatingBar
import com.example.applaudoscodechallengeandroid.ui.components.TvShowSeasonComponent
import com.example.applaudoscodechallengeandroid.ui.theme.ApplaudosTypography
import com.example.applaudoscodechallengeandroid.ui.theme.TEXT
import com.example.applaudoscodechallengeandroid.ui.theme.WHITE
import com.example.applaudoscodechallengeandroid.ui.theme.primaryColor
import com.example.applaudoscodechallengeandroid.ui.tvshowdetails.state.TvShowDetailsUiState
import com.example.applaudoscodechallengeandroid.ui.utils.Constants.CONTENT_DESCRIPTION_GO_BACK_BUTTON
import com.example.applaudoscodechallengeandroid.ui.utils.Constants.CONTENT_DESCRIPTION_IMAGE_TV_SHOW_DETAILS
import com.example.applaudoscodechallengeandroid.ui.utils.Constants.INVALID_ID

@Composable
fun TvShowDetailsRoute(
    viewModel: TvShowDetailsViewModel = hiltViewModel(),
    tvId: Int,
    goBack: () -> Unit,
) {
    val tvShowDetailsUiState by viewModel.uiState.collectAsState()

    if (viewModel.getTvId() == INVALID_ID) {
        viewModel.run {
            this.setTvId(tvId)
        }
    }

    TvShowDetailsScreen(
        uiState = tvShowDetailsUiState,
        goBack = goBack
    )

}

@Composable
fun TvShowDetailsScreen(
    uiState: TvShowDetailsUiState,
    goBack: () -> Unit
) {
    Column {
        ImageHeader(tvShowDomainModel = uiState.tvShowDomainModel, goBack = goBack)

        TvShowDescription(tvShowDomainModel = uiState.tvShowDomainModel)

        SeasonList(tvShowSeasonDomainModelList = uiState.tvShowDomainModel.seasons)
    }
}

@Composable
fun ImageHeader(
    tvShowDomainModel: TvShowDomainModel,
    goBack: () -> Unit
) {
    Box {

        IconButton(
            onClick = goBack,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.default_screen_margin))
        ) {
            Icon(Icons.Filled.ArrowBack, CONTENT_DESCRIPTION_GO_BACK_BUTTON, tint = WHITE)
        }

        Image(
            painter = rememberAsyncImagePainter(
                model = BuildConfig.BASE_IMAGE_URL + tvShowDomainModel.posterPath,
                error = painterResource(R.drawable.ic_no_image),
                placeholder = painterResource(id = R.drawable.ic_downloading)
            ),
            contentDescription = CONTENT_DESCRIPTION_IMAGE_TV_SHOW_DETAILS,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(
                    min = dimensionResource(id = R.dimen.tv_show_details_main_image_height),
                    max = dimensionResource(id = R.dimen.tv_show_details_main_image_height)
                ),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.default_screen_margin))
                .align(
                    Alignment.BottomStart
                ),
        ) {
            Text(text = tvShowDomainModel.name, color = WHITE, style = ApplaudosTypography.caption)
            Text(
                text = tvShowDomainModel.originalName,
                color = WHITE,
                style = ApplaudosTypography.h4
            )
            RatingBar(rating = tvShowDomainModel.voteAverage.toFloat())
        }
    }

}

@Composable
fun TvShowDescription(
    tvShowDomainModel: TvShowDomainModel
) {
    Column(
        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.default_screen_margin))
    ) {
        Text(
            modifier = Modifier.padding(
                top = dimensionResource(
                    id = R.dimen.tv_show_details_summary_top_margin
                )
            ),
            text = stringResource(id = R.string.tv_show_details_summary),
            color = primaryColor,
            style = ApplaudosTypography.h6,
        )
        Text(
            modifier = Modifier.padding(
                top = dimensionResource(
                    id = R.dimen.tv_show_details_overview_top_margin
                )
            ),
            text = tvShowDomainModel.overview,
            color = TEXT,
            style = ApplaudosTypography.body2
        )

    }
}


@Composable
fun SeasonList(
    tvShowSeasonDomainModelList: List<TvShowSeasonDomainModel>
) {
    LazyColumn(
        modifier = Modifier.padding(
            dimensionResource(id = R.dimen.default_screen_margin)
        ),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.tv_show_details_space_between_items))
    ) {
        items(tvShowSeasonDomainModelList) { tvShowSeasonDomainModel ->
            TvShowSeasonComponent(tvShowSeasonDomainModel = tvShowSeasonDomainModel)
        }
    }
}
