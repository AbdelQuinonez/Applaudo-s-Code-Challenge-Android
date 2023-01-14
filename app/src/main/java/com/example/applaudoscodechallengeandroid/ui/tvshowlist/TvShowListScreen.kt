package com.example.applaudoscodechallengeandroid.ui.tvshowlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.applaudoscodechallengeandroid.R
import com.example.applaudoscodechallengeandroid.domain.model.SortBy
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.navigation.NavigationDestinations
import com.example.applaudoscodechallengeandroid.ui.components.SortChip
import com.example.applaudoscodechallengeandroid.ui.components.TvShowComposable
import com.example.applaudoscodechallengeandroid.ui.tvshowlist.state.TvShowListUiState

@Composable
fun TvShowListRoute(
    navigateTo: (String) -> Unit,
    viewModel: TvShowListViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    TvShowListScreen(
        navigateTo = navigateTo,
        uiState = uiState,
        viewModel::sortBy
    )
}

@Composable
fun TvShowListScreen(
    navigateTo: (String) -> Unit,
    uiState: TvShowListUiState,
    sortBy: (String) -> Unit
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
                    .padding(
                        start = dimensionResource(id = R.dimen.default_screen_margin),
                        end = dimensionResource(id = R.dimen.default_screen_margin),
                        bottom = dimensionResource(id = R.dimen.default_screen_margin)
                    )
            ) {
                SortByChipGroup(selectedSortBy = uiState.sortBy, onSelectedChanged = {
                    sortBy(it)
                })
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

    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.tv_show_list_space_between_items)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.tv_show_list_space_between_items)),
        columns = GridCells.Fixed(numberOfColumns),
        content = {
            items(tvShowDomainModelList) { tvShowDomainModel ->
                TvShowComposable(
                    tvShowDomainModel = tvShowDomainModel,
                    onClick = { onClick(tvShowDomainModel.id) }
                )
            }
        })

}

@Composable
fun SortByChipGroup(
    selectedSortBy: SortBy?,
    onSelectedChanged: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(
            vertical = dimensionResource(id = R.dimen.tv_show_list_margin_top_bottom_chips)
        ),
        content = {
            items(SortBy.values()) { sortBy ->
                SortChip(
                    name = sortBy.value,
                    isSelected = selectedSortBy == sortBy,
                    onSelectionChanged = onSelectedChanged
                )
            }
        },
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.tv_show_list_space_between_chips))
    )


}
