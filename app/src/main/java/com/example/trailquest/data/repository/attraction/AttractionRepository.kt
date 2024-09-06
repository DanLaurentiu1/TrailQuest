package com.example.trailquest.data.repository.attraction

import com.example.trailquest.data.entities.Attraction
import kotlinx.coroutines.flow.Flow

interface AttractionRepository {
    fun getAllAttractions(): Flow<List<Attraction>>

    fun getAttractionByName(name: String): Flow<Attraction>

    suspend fun upsert(attraction: Attraction)

    suspend fun delete(attraction: Attraction)
}