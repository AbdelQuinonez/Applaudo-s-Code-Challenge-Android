package com.example.applaudoscodechallengeandroid.localdatasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applaudoscodechallengeandroid.localdatasource.database.daos.TvShowDao
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCache

@Database(entities = [TvShowCache::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tvShow(): TvShowDao
}