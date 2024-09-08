package com.example.trailquest.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.trailquest.data.entities.Type
import kotlinx.coroutines.flow.Flow

@Dao
interface TypeDao {
    @Query("SELECT * from Types")
    fun getAllTypes(): Flow<List<Type>>

    @Query("SELECT * from Types WHERE name = :name")
    fun getTypeByName(name: String): Flow<Type>

    @Query("SELECT * from Types WHERE id = :id")
    fun getTypeById(id: Int): Flow<Type>

    @Upsert
    suspend fun upsert(type: Type)

    @Delete
    suspend fun delete(type: Type)
}