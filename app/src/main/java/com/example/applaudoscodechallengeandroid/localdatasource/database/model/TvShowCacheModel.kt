package com.example.applaudoscodechallengeandroid.localdatasource.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel
import com.example.applaudoscodechallengeandroid.domain.model.TvShowSeasonDomainModel

@Entity
data class TvShowCacheModel(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo
    val posterPath: String = "",
    @ColumnInfo
    val popularity: Double = 0.0,
    @ColumnInfo
    val overview: String = "",
    @ColumnInfo
    val name: String = "",
    @ColumnInfo
    val originalName: String = "",
    @ColumnInfo
    val voteAverage: Double = 0.0,
) {
    fun mapFromCacheToDomain(): TvShowDomainModel {
        return TvShowDomainModel(
            id = this.id,
            name = this.name,
            originalName = this.originalName,
            voteAverage = this.voteAverage,
            posterPath = this.posterPath,
            popularity = this.popularity,
            overview = this.overview,
        )
    }
}