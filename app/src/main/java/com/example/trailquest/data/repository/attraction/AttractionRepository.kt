package com.example.trailquest.data.repository.attraction

import com.example.trailquest.data.entities.Attraction
import kotlinx.coroutines.flow.Flow

interface AttractionRepository {
    fun getAllAttractions(): Flow<List<Attraction>>

    fun getAttractionByName(name: String): Flow<Attraction>

    fun getAttractionById(id: Int): Flow<Attraction>

    fun getAttractionsByCountryAndType(countryId: Int, typeId: Int): Flow<List<Attraction>>

    fun getNumberOfCompletedAttractionsByType(typeId: Int): Flow<Int>

    fun getNumberOfTotalAttractionsByType(typeId: Int): Flow<Int>

    fun getNumberOfCompletedAttractionsByTypeAndCountry(typeId: Int, countryId: Int): Flow<Int>

    fun getNumberOfTotalAttractionsByTypeAndCountry(typeId: Int, countryId: Int): Flow<Int>

    fun getTotalNumberOfAttractions(): Flow<Int>

    fun getNumberOfCompletedAttractions(): Flow<Int>

    fun getMostLikedActivities(numberOfCountries: Int): Flow<List<Int>>

    suspend fun upsert(attraction: Attraction)

    suspend fun delete(attraction: Attraction)
}