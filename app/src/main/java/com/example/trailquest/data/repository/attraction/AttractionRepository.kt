package com.example.trailquest.data.repository.attraction

import com.example.trailquest.data.entities.Attraction
import kotlinx.coroutines.flow.Flow

interface AttractionRepository {
    fun getAllAttractions(): Flow<List<Attraction>>

    fun getAttractionByName(name: String): Flow<Attraction>

    fun getAttractionsByCountryAndType(countryId: Int, typeId: Int): Flow<List<Attraction>>

    fun getNumberOfCompletedAttractionsByType(typeId: Int): Flow<Float>

    fun getNumberOfTotalAttractionsByType(typeId: Int): Flow<Float>

    fun getNumberOfCompletedAttractionsByTypeAndCountry(typeId: Int, countryId: Int): Flow<Float>

    fun getNumberOfTotalAttractionsByTypeAndCountry(typeId: Int, countryId: Int): Flow<Float>

    suspend fun upsert(attraction: Attraction)

    suspend fun delete(attraction: Attraction)
}