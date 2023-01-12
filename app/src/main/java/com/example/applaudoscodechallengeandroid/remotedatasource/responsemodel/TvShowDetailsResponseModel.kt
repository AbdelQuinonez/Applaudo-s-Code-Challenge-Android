package com.example.applaudoscodechallengeandroid.remotedatasource.responsemodel

import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowDetailsCacheModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowSeasonCacheModel
import com.google.gson.annotations.SerializedName

data class TvShowDetailsResponseModel (

    @field:SerializedName("backdrop_path")
    val backdropPath: String = "",
    @field:SerializedName("created_by")
    val createdBy: List<CreatedBy> = listOf(),
    @field:SerializedName("episode_run_time")
    val episodeRunTime: List<Int> = listOf(),
    @field:SerializedName("first_air_date")
    val firstAirDate: String = "",
    @field:SerializedName("genres")
    val genres: List<Genres> = listOf(),
    @field:SerializedName("homepage")
    val homepage: String = "",
    @field:SerializedName("id")
    val id: Int = 0,
    @field:SerializedName("in_production")
    val inProduction: Boolean = false,
    @field:SerializedName("languages")
    val languages: List<String> = listOf(),
    @field:SerializedName("last_air_date")
    val lastAirDate: String = "",
    @field:SerializedName("last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAir = LastEpisodeToAir(),
    @field:SerializedName("name")
    val name: String = "",
    @field:SerializedName("next_episode_to_air")
    val nextEpisodeToAir: String = "",
    @field:SerializedName("networks")
    val networks: List<Networks> = listOf(),
    @field:SerializedName("number_of_episodes")
    val numberOfEpisodes: Int = 0,
    @field:SerializedName("number_of_seasons")
    val numberOfSeasons: Int = 0,
    @field:SerializedName("origin_country")
    val originCountry: List<String> = listOf(),
    @field:SerializedName("original_language")
    val originalLanguage: String = "",
    @field:SerializedName("original_name")
    val originalName: String = "",
    @field:SerializedName("overview")
    val overview: String = "",
    @field:SerializedName("popularity")
    val popularity: Double = 0.0,
    @field:SerializedName("poster_path")
    val posterPath: String = "",
    @field:SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanies> = listOf(),
    @field:SerializedName("production_countries")
    val productionCountries: List<ProductionCountries> = listOf(),
    @field:SerializedName("seasons")
    val seasons: List<Seasons> = listOf(),
    @field:SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguages> = listOf(),
    @field:SerializedName("status")
    val status: String = "",
    @field:SerializedName("tagline")
    val tagline: String = "",
    @field:SerializedName("type")
    val type: String = "",
    @field:SerializedName("vote_average")
    val voteAverage: Double = 0.0,
    @field:SerializedName("vote_count")
    val voteCount: Int = 0
){
    fun mapFromRemoteToDomainModel(
        tvShowDetailsResponseModel: TvShowDetailsResponseModel
    ): TvShowDetailsCacheModel {
        return TvShowDetailsCacheModel(
            id = tvShowDetailsResponseModel.id,
            posterPath = tvShowDetailsResponseModel.posterPath,
            popularity = tvShowDetailsResponseModel.popularity,
            overview = tvShowDetailsResponseModel.overview
        )
    }

    fun mapSeasonFromRemoteToDomainModel(
        tvShowDetailsResponseModel: TvShowDetailsResponseModel
    ): List<TvShowSeasonCacheModel>{
        val seasonList = tvShowDetailsResponseModel.seasons
        return List(seasonList.size){ i ->
            val season = seasonList[i]
            TvShowSeasonCacheModel(
                id = season.id,
                tvId = tvShowDetailsResponseModel.id,
                name = season.name,
                overview = season.overview,
                posterPath = season.posterPath,
                seasonNumber = season.seasonNumber
            )
        }
    }
}

data class CreatedBy(
    @field:SerializedName("id")
    val id: Int = 0,
    @field:SerializedName("credit_id")
    val creditId: String = "",
    @field:SerializedName("name")
    val name: String = "",
    @field:SerializedName("gender")
    val gender: Int = 0,
    @field:SerializedName("profile_path")
    val profilePath: String = ""
)

data class Genres(
    @field:SerializedName("id")
    val id: Int = 0,
    @field:SerializedName("name")
    val name: String = ""
)

data class LastEpisodeToAir(
    @field:SerializedName("air_date")
    val airDate: String = "",
    @field:SerializedName("episode_number")
    val episodeNumber: Int = 0,
    @field:SerializedName("id")
    val id: Int = 0,
    @field:SerializedName("name")
    val name: String = "",
    @field:SerializedName("overview")
    val overview: String = "",
    @field:SerializedName("production_code")
    val productionCode: String = "",
    @field:SerializedName("season_number")
    val seasonNumber: Int = 0,
    @field:SerializedName("still_path")
    val stillPath: String = "",
    @field:SerializedName("vote_average")
    val voteAverage: Double = 0.0,
    @field:SerializedName("vote_count")
    val voteCount: Int = 0
)

data class Networks(
    @field:SerializedName("name")
    val name: String = "",
    @field:SerializedName("id")
    val id: Int = 0,
    @field:SerializedName("logo_path")
    val logoPath: String = "",
    @field:SerializedName("origin_country")
    val originCountry: String = ""
)

data class ProductionCompanies(

    @field:SerializedName("id") val
    id: Int = 0,
    @field:SerializedName("logo_path")
    val logoPath: String = "",
    @field:SerializedName("name")
    val name: String = "",
    @field:SerializedName("origin_country")
    val originCountry: String = ""

)

data class ProductionCountries(
    @field:SerializedName("iso_3166_1")
    val iso31661: String = "",
    @field:SerializedName("name")
    val name: String = ""
)

data class Seasons(
    @field:SerializedName("air_date")
    val airDate: String = "",
    @field:SerializedName("episode_count")
    val episodeCount: Int = 0,
    @field:SerializedName("id")
    val id: Int = 0,
    @field:SerializedName("name")
    val name: String = "",
    @field:SerializedName("overview")
    val overview: String = "",
    @field:SerializedName("poster_path")
    val posterPath: String = "",
    @field:SerializedName("season_number")
    val seasonNumber: Int = 0
)

data class SpokenLanguages(
    @field:SerializedName("english_name")
    val englishName: String = "",
    @field:SerializedName("iso_639_1")
    val iso6391: String = "",
    @field:SerializedName("name")
    val name: String = ""
)