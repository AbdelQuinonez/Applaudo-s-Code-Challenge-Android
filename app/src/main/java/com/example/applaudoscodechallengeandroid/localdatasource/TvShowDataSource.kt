package com.example.applaudoscodechallengeandroid.localdatasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel

class TvShowDataSource(
    private val localRepository: LocalRepository,
) : PagingSource<Int, TvShowCacheModel>() {

    override fun getRefreshKey(state: PagingState<Int, TvShowCacheModel>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShowCacheModel> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = localRepository.getTvShows()
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = if (response.isNotEmpty()) 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val NUMBER_OF_TV_SHOWS_PER_REQUEST = 10
    }

}