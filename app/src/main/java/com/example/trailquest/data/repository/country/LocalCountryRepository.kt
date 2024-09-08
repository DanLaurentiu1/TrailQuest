package com.example.trailquest.data.repository.country

import com.example.trailquest.data.dao.CountryDao
import com.example.trailquest.data.entities.Country
import kotlinx.coroutines.flow.Flow

class LocalCountryRepository(private val countryDao: CountryDao) : CountryRepository {
    override fun getAllCountries(): Flow<List<Country>> {
        return countryDao.getAllCountries()
    }

    override fun getCountryByName(name: String): Flow<Country> {
        return countryDao.getCountryByName(name)
    }

    override fun getCountryById(id: Int): Flow<Country> {
        return countryDao.getCountryById(id)
    }

    override fun getMostCompletedCountry(numberOfCountries: Int): Flow<List<Int>> {
        return countryDao.getMostCompletedCountry(numberOfCountries)
    }

    override suspend fun upsert(country: Country) {
        return countryDao.upsert(country)
    }

    override suspend fun delete(country: Country) {
        return countryDao.delete(country)
    }
}
