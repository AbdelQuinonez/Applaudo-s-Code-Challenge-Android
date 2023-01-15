package com.example.applaudoscodechallengeandroid.localdatasource.database.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class TvShowSeasonCacheModel(
    @PrimaryKey
    val id : Int = 0,
    @ColumnInfo
    val tvId: Int = 0,
    @ColumnInfo
    val name : String = "",
    @ColumnInfo
    val overview: String = "",
    @ColumnInfo
    val posterPath: String = "",
    @ColumnInfo
    val seasonNumber: Int = 0,
    @ColumnInfo
    val episodeCount: Int = 0
)