package com.example.applaudoscodechallengeandroid.localdatasource.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.applaudoscodechallengeandroid.localdatasource.database.model.TvShowSeasonCacheModel

@Dao
interface TvShowSeasonDao {

    @Query("SELECT * FROM TvShowSeasonCacheModel WHERE tvId = :tvId")
    suspend fun getAll(tvId: Int): List<TvShowSeasonCacheModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tvShowSeasonCacheModelList: List<TvShowSeasonCacheModel>): List<Long>

}