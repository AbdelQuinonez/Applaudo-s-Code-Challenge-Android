package com.example.applaudoscodechallengeandroid.localdatasource.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.applaudoscodechallengeandroid.domain.model.TvShowSeasonDomainModel

@Entity
class TvShowSeasonCacheModel(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo
    val tvId: Int = 0,
    @ColumnInfo
    val name: String = "",
    @ColumnInfo
    val overview: String = "",
    @ColumnInfo
    val posterPath: String = "",
    @ColumnInfo
    val seasonNumber: Int = 0,
    @ColumnInfo
    val episodeCount: Int = 0
) {
    fun mapFromCacheToDomainModel(): TvShowSeasonDomainModel =
        TvShowSeasonDomainModel(
            id = this.id,
            name = this.name,
            overview = this.overview,
            posterPath = this.posterPath,
            episodeCount = this.episodeCount,
            seasonNumber = this.episodeCount
        )
}