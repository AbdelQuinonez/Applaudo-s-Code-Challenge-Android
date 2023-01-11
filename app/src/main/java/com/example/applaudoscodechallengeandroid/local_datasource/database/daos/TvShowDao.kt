package com.example.applaudoscodechallengeandroid.local_datasource.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.applaudoscodechallengeandroid.local_datasource.database.model.TvShowCache

@Dao
interface TvShowDao{
    @Query("SELECT * FROM TvShowCache")
    suspend fun getAll(): List<TvShowCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(runningAppProcess: List<TvShowCache>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(runningAppProcessCacheCaches: TvShowCache): Long
}