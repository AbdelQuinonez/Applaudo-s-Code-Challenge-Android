package com.example.applaudoscodechallengeandroid.localdatasource.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowCache
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowDao {
    @Query("SELECT * FROM TvShowCache")
    suspend fun getAll(): List<TvShowCache>

    @Query("SELECT * FROM TvShowCache WHERE id = :id")
    suspend fun getTvShow(id: String): TvShowCache

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tvShowsCache: List<TvShowCache>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvShowCache: TvShowCache): Long
}