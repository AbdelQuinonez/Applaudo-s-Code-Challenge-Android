package com.example.applaudoscodechallengeandroid.tvshowdetails

import com.example.applaudoscodechallengeandroid.core.successOr
import com.example.applaudoscodechallengeandroid.data.TestLocalRepository
import com.example.applaudoscodechallengeandroid.data.TestNetworkApi
import com.example.applaudoscodechallengeandroid.data.TestTvShowRepository
import com.example.applaudoscodechallengeandroid.domain.interactors.GetTvShowDetailsUseCase
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.ui.tvshowdetails.TvShowDetailsViewModel
import com.example.applaudoscodechallengeandroid.utils.TestingConstants.TEST_DEFAULT_ID
import com.example.applaudoscodechallengeandroid.utils.TestingConstants.TEST_DEFAULT_POPULARITY
import com.example.applaudoscodechallengeandroid.utils.TestingConstants.TEST_DEFAULT_VOTE_AVERAGE
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
class TestTvShowDetailsViewModel {

    private val dispatcher = StandardTestDispatcher()

    private val tvShowRepository = TestTvShowRepository()
    private val localRepository = TestLocalRepository()
    private val networkApi = TestNetworkApi()

    private val getTvShowDetailsUseCase: GetTvShowDetailsUseCase = GetTvShowDetailsUseCase(
        tvShowRepository = tvShowRepository,
        localRepository = localRepository,
        networkApi = networkApi
    )

    private lateinit var viewModel: TvShowDetailsViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = TvShowDetailsViewModel(
            getTvShowDetailsUseCase
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testModelIsAboveVoteAvg(): Unit = runBlocking {
        val response = viewModel.getTvShowDetailsUseCase(TEST_DEFAULT_ID)
        val model = response.successOr(TvShowDomainModel())
        assert(model.voteAverage > TEST_DEFAULT_VOTE_AVERAGE)
    }

    @Test
    fun testModelIsAbovePopularity(): Unit = runBlocking {
        val response = viewModel.getTvShowDetailsUseCase(TEST_DEFAULT_ID)
        val model = response.successOr(TvShowDomainModel())
        assert(model.popularity > TEST_DEFAULT_POPULARITY)
    }

    @Test
    fun testModelHasNoEmptyPosterPath(): Unit = runBlocking {
        val response = viewModel.getTvShowDetailsUseCase(TEST_DEFAULT_ID)
        val model = response.successOr(TvShowDomainModel())
        assert(model.posterPath.isNotEmpty())
    }

}