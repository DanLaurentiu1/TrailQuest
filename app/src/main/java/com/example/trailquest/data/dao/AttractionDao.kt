package com.example.trailquest.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.trailquest.data.entities.Attraction
import kotlinx.coroutines.flow.Flow

@Dao
interface AttractionDao {
    @Query("SELECT * from Attractions")
    fun getAllAttractions(): Flow<List<Attraction>>

    @Query("SELECT * from Attractions WHERE name = :name")
    fun getAttractionByName(name: String): Flow<Attraction>

    @Upsert
    suspend fun upsert(attraction: Attraction)

    @Delete
    suspend fun delete(attraction: Attraction)
}