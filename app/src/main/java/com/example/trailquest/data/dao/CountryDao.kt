package com.example.trailquest.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.trailquest.data.entities.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    @Query("SELECT * from Countries")
    fun getAllCountries(): Flow<List<Country>>

    @Query("SELECT * from Countries WHERE name = :name")
    fun getCountryByName(name: String): Flow<Country>

    @Query("SELECT * from Countries WHERE id = :id")
    fun getCountryById(id: Int): Flow<Country>

    @Query("SELECT countryId FROM Attractions WHERE completed = 1 GROUP BY countryId ORDER BY COUNT(countryId) DESC LIMIT :numberOfCountries")
    fun getMostCompletedCountry(numberOfCountries: Int): Flow<List<Int>>

    @Upsert
    suspend fun upsert(country: Country)

    @Delete
    suspend fun delete(country: Country)
}