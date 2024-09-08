package com.example.trailquest.data.repository.type

import com.example.trailquest.data.dao.TypeDao
import com.example.trailquest.data.entities.Type
import kotlinx.coroutines.flow.Flow

class LocalTypeRepository(private val typeDao: TypeDao) : TypeRepository {
    override fun getAllTypes(): Flow<List<Type>> {
        return typeDao.getAllTypes()
    }

    override fun getTypeByName(name: String): Flow<Type> {
        return typeDao.getTypeByName(name)
    }

    override fun getTypeById(id: Int): Flow<Type> {
        return typeDao.getTypeById(id)
    }

    override suspend fun upsert(type: Type) {
        return typeDao.upsert(type)
    }

    override suspend fun delete(type: Type) {
        return typeDao.delete(type)
    }
}