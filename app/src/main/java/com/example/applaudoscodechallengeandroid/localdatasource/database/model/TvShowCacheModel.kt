package com.example.applaudoscodechallengeandroid.localdatasource.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
)