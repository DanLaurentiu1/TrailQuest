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

    override fun getAttractionsByCountryAndType(
        countryId: Int,
        typeId: Int
    ): Flow<List<Attraction>> {
        return attractionDao.getAttractionsByCountryAndType(countryId = countryId, typeId = typeId)
    }

    override fun getNumberOfCompletedAttractionsByType(typeId: Int): Flow<Float> {
        return attractionDao.getNumberOfCompletedAttractionsByType(typeId = typeId)
    }

    override fun getNumberOfTotalAttractionsByType(typeId: Int): Flow<Float> {
        return attractionDao.getNumberOfTotalAttractionsByType(typeId = typeId)
    }

    override fun getNumberOfCompletedAttractionsByTypeAndCountry(
        typeId: Int,
        countryId: Int
    ): Flow<Float> {
        return attractionDao.getNumberOfCompletedAttractionsByTypeAndCountry(
            typeId = typeId,
            countryId = countryId
        )
    }

    override fun getNumberOfTotalAttractionsByTypeAndCountry(
        typeId: Int,
        countryId: Int
    ): Flow<Float> {
        return attractionDao.getNumberOfTotalAttractionsByTypeAndCountry(
            typeId = typeId,
            countryId = countryId
        )
    }

    override suspend fun upsert(attraction: Attraction) {
        return attractionDao.upsert(attraction)
    }

    override suspend fun delete(attraction: Attraction) {
        return attractionDao.delete(attraction)
    }
}