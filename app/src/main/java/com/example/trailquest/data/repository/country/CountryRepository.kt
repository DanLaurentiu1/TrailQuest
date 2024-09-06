package com.example.trailquest.data.repository.country

import com.example.trailquest.data.entities.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    fun getAllCountries(): Flow<List<Country>>

    fun getCountryByName(name: String): Flow<Country>

    suspend fun upsert(country: Country)

    suspend fun delete(country: Country)
}