package com.example.trailquest.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.trailquest.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * from Users")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * from Users WHERE id = :id")
    fun getUserById(id: Int): Flow<User>

    @Upsert
    suspend fun upsert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM Users WHERE name = :name")
    suspend fun deleteByName(name: String)
}