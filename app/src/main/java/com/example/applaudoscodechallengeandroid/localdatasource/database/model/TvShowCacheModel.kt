package com.example.applaudoscodechallengeandroid.localdatasource.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.applaudoscodechallengeandroid.domain.model.TvShowDomainModel

@Entity
data class TvShowCacheModel(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo
    val name: String = "",
    @ColumnInfo
    val voteAverage: Double = 0.0,
    @ColumnInfo
    val posterPath: String = "",
    @ColumnInfo
    val popularity: Double = 0.0,
    @ColumnInfo
    val overview: String = ""
){
    fun mapFromCacheToDomain(): TvShowDomainModel{
        return TvShowDomainModel(
            id = this.id,
            name = this.name,
            voteAverage = this.voteAverage,
            posterPath = this.posterPath,
            popularity = this.popularity,
            overview = this.overview
        )
    }

}