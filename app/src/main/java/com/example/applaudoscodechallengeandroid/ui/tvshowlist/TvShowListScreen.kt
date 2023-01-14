package com.example.applaudoscodechallengeandroid.ui.tvshowlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.applaudoscodechallengeandroid.R
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.navigation.NavigationDestinations
import com.example.applaudoscodechallengeandroid.ui.components.TvShowComposable
import com.example.applaudoscodechallengeandroid.ui.tvshowlist.state.TvShowListUiState

@Composable
fun TvShowListRoute(
    navigateTo: (String) -> Unit,
    viewModel: TvShowListViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    TvShowListScreen(
        navigateTo,
        uiState = uiState
    )
}

@Composable
fun TvShowListScreen(
    navigateTo: (String) -> Unit,
    uiState: TvShowListUiState
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.tv_shows_list_screen_title))
                })
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                TvShowList(
                    tvShowDomainModelList = uiState.tvShowDomainModelList,
                    onClick = { tvId ->
                        navigateTo(
                            "${NavigationDestinations.TV_SHOW_DETAILS_SCREEN}/${tvId}"
                        )
                    })
            }
        }
    )

}

@Composable
fun TvShowList(tvShowDomainModelList: List<TvShowDomainModel>, onClick: (Int) -> Unit) {

    val numberOfColumns = 2

    LazyVerticalGrid(columns = GridCells.Fixed(numberOfColumns), content = {
        items(tvShowDomainModelList) { tvShowDomainModel ->
            TvShowComposable(
                tvShowDomainModel = tvShowDomainModel,
                onClick = { onClick(tvShowDomainModel.id) }
            )
        }
    })

}
