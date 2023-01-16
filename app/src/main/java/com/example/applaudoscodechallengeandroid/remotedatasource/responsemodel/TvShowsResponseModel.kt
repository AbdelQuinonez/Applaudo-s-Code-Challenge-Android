package com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel

import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel
import com.google.gson.annotations.SerializedName

data class TvShowsResponseModel(
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("results")
    val results: List<Results> = listOf(),
    @SerializedName("total_results")
    val totalResults: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0
) {
    fun mapFromRemoteToCacheModel(
    ): List<TvShowCacheModel> {
        val tvShowCacheModelList = mutableListOf<TvShowCacheModel>()

        this.results.forEach { result ->
            tvShowCacheModelList.add(
                TvShowCacheModel(
                    id = result.id,
                    name = result.name.orEmpty(),
                    posterPath = result.posterPath.orEmpty(),
                    voteAverage = result.voteAverage,
                    popularity = result.popularity,
                    overview = result.overview.orEmpty(),
                    originalName = result.originalName.orEmpty()
                )
            )
        }
        return tvShowCacheModelList
    }

}

data class Results(
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("popularity")
    val popularity: Double = 0.0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,
    @SerializedName("overview")
    val overview: String? = "",
    @SerializedName("first_air_date")
    val firstAirDate: String = "",
    @SerializedName("origin_country")
    val originCountry: List<String> = listOf(),
    @SerializedName("genre_ids")
    val genreIds: List<Int> = listOf(),
    @SerializedName("original_language")
    val originalLanguage: String = "",
    @SerializedName("vote_count")
    val voteCount: Int = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("original_name")
    val originalName: String? = ""
)



