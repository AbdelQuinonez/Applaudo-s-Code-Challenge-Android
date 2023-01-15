package com.example.applaudoscodechallengeandroid.localdatasource.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCacheModel

@Dao
interface TvShowDao {
    @Query("SELECT * FROM TvShowCacheModel")
    suspend fun getAll(): List<TvShowCacheModel>

    @Query("SELECT * FROM TvShowCacheModel WHERE id = :id")
    suspend fun getTvShow(id: Int): TvShowCacheModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tvShowsCache: List<TvShowCacheModel>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvShowCacheModel: TvShowCacheModel): Long
}