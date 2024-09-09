package com.example.trailquest.data.repository.attraction

import com.example.trailquest.data.dao.AttractionDao
import com.example.trailquest.data.entities.Attraction
import kotlinx.coroutines.flow.Flow

class LocalAttractionRepository(private val attractionDao: AttractionDao) : AttractionRepository {
    override fun getAllAttractions(): Flow<List<Attraction>> {
        return attractionDao.getAllAttractions()
    }

    override fun getAttractionByName(name: String): Flow<Attraction> {
        return attractionDao.getAttractionByName(name)
    }

    override fun getAttractionById(id: Int): Flow<Attraction> {
        return attractionDao.getAttractionById(id)
    }

    override fun getAttractionsByCountryName(countryName: String): Flow<List<Attraction>> {
        return attractionDao.getAttractionsByCountryName(countryName)
    }

    override fun getAttractionsByCountryAndType(
        countryId: Int,
        typeId: Int
    ): Flow<List<Attraction>> {
        return attractionDao.getAttractionsByCountryAndType(countryId = countryId, typeId = typeId)
    }

    override fun getNumberOfCompletedAttractionsByType(typeId: Int): Flow<Int> {
        return attractionDao.getNumberOfCompletedAttractionsByType(typeId = typeId)
    }

    override fun getNumberOfTotalAttractionsByType(typeId: Int): Flow<Int> {
        return attractionDao.getNumberOfTotalAttractionsByType(typeId = typeId)
    }

    override fun getNumberOfCompletedAttractionsByTypeAndCountry(
        typeId: Int,
        countryId: Int
    ): Flow<Int> {
        return attractionDao.getNumberOfCompletedAttractionsByTypeAndCountry(
            typeId = typeId,
            countryId = countryId
        )
    }

    override fun getNumberOfTotalAttractionsByTypeAndCountry(
        typeId: Int,
        countryId: Int
    ): Flow<Int> {
        return attractionDao.getNumberOfTotalAttractionsByTypeAndCountry(
            typeId = typeId,
            countryId = countryId
        )
    }

    override fun getTotalNumberOfAttractions(): Flow<Int> {
        return attractionDao.getTotalNumberOfAttractions()
    }

    override fun getNumberOfCompletedAttractions(): Flow<Int> {
        return attractionDao.getNumberOfCompletedAttractions()
    }

    override fun getMostLikedActivities(numberOfCountries: Int): Flow<List<Int>> {
        return attractionDao.getMostLikedActivities(numberOfCountries)
    }

    override suspend fun upsert(attraction: Attraction) {
        return attractionDao.upsert(attraction)
    }

    override suspend fun delete(attraction: Attraction) {
        return attractionDao.delete(attraction)
    }
}