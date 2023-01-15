package com.example.applaudoscodechallengeandroid.localdatasource.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.applaudoscodechallengeandroid.domain.model.TvShowSeasonDomainModel

@Entity
class TvShowDetailsCacheModel (
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo
    val posterPath: String = "",
    @ColumnInfo
    val popularity: Double = 0.0,
    @ColumnInfo
    val overview: String = "",
    val seasons: List<TvShowSeasonCacheModel> = listOf()
)