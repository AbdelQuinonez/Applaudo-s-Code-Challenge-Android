package com.example.applaudoscodechallengeandroid.localdatasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applaudoscodechallengeandroid.localdatasource.database.daos.TvShowDao
import com.example.applaudoscodechallengeandroid.localdatasource.database.daos.TvShowSeasonDao
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowSeasonCacheModel

@Database(entities = [TvShowCacheModel::class, TvShowSeasonCacheModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tvShow(): TvShowDao
    abstract fun tvShowSeason(): TvShowSeasonDao
}