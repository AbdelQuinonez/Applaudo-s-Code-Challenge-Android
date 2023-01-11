package com.example.applaudoscodechallengeandroid.local_datasource.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TvShowCache(
    @PrimaryKey val id : Long = 0,
    @ColumnInfo val name : String = "",
    @ColumnInfo val vote_average : Int = 0,
    @ColumnInfo val backdrop_path : String = "",
    @ColumnInfo val status : String = ""
)