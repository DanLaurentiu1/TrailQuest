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

    @Query("SELECT * from Attractions WHERE id = :id")
    fun getAttractionById(id: Int): Flow<Attraction>

    @Query("SELECT * from Attractions where countryId = :countryId")
    fun getAttractionWithCountryId(countryId: Int): Flow<List<Attraction>>

    @Query("SELECT * from Attractions where countryId = :countryId and typeId = :typeId")
    fun getAttractionsByCountryAndType(countryId: Int, typeId: Int): Flow<List<Attraction>>

    @Query("SELECT COUNT(*) from Attractions where typeId = :typeId and completed = 1")
    fun getNumberOfCompletedAttractionsByType(typeId: Int): Flow<Int>

    @Query("SELECT COUNT(*) from Attractions where typeId = :typeId")
    fun getNumberOfTotalAttractionsByType(typeId: Int): Flow<Int>

    @Query("SELECT COUNT(*) from Attractions where typeId = :typeId and countryId = :countryId and  completed = 1")
    fun getNumberOfCompletedAttractionsByTypeAndCountry(typeId: Int, countryId: Int): Flow<Int>

    @Query("SELECT COUNT(*) from Attractions where typeId = :typeId and countryId = :countryId")
    fun getNumberOfTotalAttractionsByTypeAndCountry(typeId: Int, countryId: Int): Flow<Int>

    @Query("SELECT COUNT(*) from Attractions")
    fun getTotalNumberOfAttractions(): Flow<Int>

    @Query("SELECT COUNT(*) from Attractions where completed = 1")
    fun getNumberOfCompletedAttractions(): Flow<Int>

    @Query("SELECT typeId FROM Attractions WHERE completed = 1 GROUP BY typeId ORDER BY COUNT(typeId) DESC LIMIT :numberOfCountries")
    fun getMostLikedActivities(numberOfCountries: Int): Flow<List<Int>>

    @Upsert
    suspend fun upsert(attraction: Attraction)

    @Delete
    suspend fun delete(attraction: Attraction)
}