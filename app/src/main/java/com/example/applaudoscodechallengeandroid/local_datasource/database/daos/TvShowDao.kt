package com.example.applaudoscodechallengeandroid.local_datasource.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.applaudoscodechallengeandroid.local_datasource.database.model.TvShowCache
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowDao {
    @Query("SELECT * FROM TvShowCache")
    suspend fun getAll(): Flow<List<TvShowCache>>

    @Query("SELECT * FROM TvShowCache WHERE id = :id")
    suspend fun getTvShow(id: String): Flow<TvShowCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tvShows: List<TvShowCache>): Flow<List<Long>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvShow: TvShowCache): Flow<Long>
}