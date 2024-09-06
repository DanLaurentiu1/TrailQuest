package com.example.trailquest.data.repository.user

import com.example.trailquest.data.entities.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsers(): Flow<List<User>>

    fun getUserById(id: Int): Flow<User?>

    suspend fun upsertUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun deleteByName(name: String)
}