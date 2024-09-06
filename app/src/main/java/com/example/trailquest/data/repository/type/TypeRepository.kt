package com.example.trailquest.data.repository.type

import com.example.trailquest.data.entities.Type
import kotlinx.coroutines.flow.Flow

interface TypeRepository {
    fun getAllTypes(): Flow<List<Type>>

    fun getTypeByName(name: String): Flow<Type>

    suspend fun upsert(type: Type)

    suspend fun delete(type: Type)
}