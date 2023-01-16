package com.example.applaudoscodechallengeandroid.tvshowlist

import com.example.applaudoscodechallengeandroid.core.successOr
import com.example.applaudoscodechallengeandroid.data.TestLocalRepository
import com.example.applaudoscodechallengeandroid.data.TestNetworkApi
import com.example.applaudoscodechallengeandroid.data.TestTvShowRepository
import com.example.applaudoscodechallengeandroid.domain.interactors.GetTvShowsUseCase
import com.example.applaudoscodechallengeandroid.ui.tvshowlist.TvShowListViewModel
import com.example.applaudoscodechallengeandroid.utils.TestConstants.TEST_DEFAULT_ID
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TestTvShowListViewModel {


    private val dispatcher = StandardTestDispatcher()

    private val tvShowRepository = TestTvShowRepository()
    private val localRepository = TestLocalRepository()
    private val networkApi = TestNetworkApi()

    private val getTvShowUseCase: GetTvShowsUseCase = GetTvShowsUseCase(
        tvShowRepository = tvShowRepository,
        localRepository = localRepository,
        networkApi
    )

    private lateinit var viewModel: TvShowListViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = TvShowListViewModel(
            getTvShowUseCase
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testListOfModelsIsNotEmpty(): Unit = runBlocking {
        val response = viewModel.getTvShowsUseCase()
        val model = response.successOr(listOf())
        assert(model.isNotEmpty())
    }

    @Test
    fun testModelHasDefaultId(): Unit = runBlocking {
        val response = viewModel.getTvShowsUseCase()
        val model = response.successOr(listOf())
        val item = model.first()
        assert(item.id == TEST_DEFAULT_ID)
    }

    @Test
    fun testModelHasNoSeasons(): Unit = runBlocking {
        val response = viewModel.getTvShowsUseCase()
        val model = response.successOr(listOf())
        val item = model.first()
        assert(item.seasons.isEmpty())
    }

}