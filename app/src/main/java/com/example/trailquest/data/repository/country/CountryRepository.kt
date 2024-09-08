package com.example.trailquest.data.repository.country

import com.example.trailquest.data.entities.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    fun getAllCountries(): Flow<List<Country>>

    fun getCountryByName(name: String): Flow<Country>

    fun getCountryById(id: Int): Flow<Country>

    fun getMostCompletedCountry(numberOfCountries: Int): Flow<List<Int>>

    suspend fun upsert(country: Country)

    suspend fun delete(country: Country)
}