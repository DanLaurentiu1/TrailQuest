package com.example.trailquest.data.repository.user

import com.example.trailquest.data.dao.UserDao
import com.example.trailquest.data.entities.User
import kotlinx.coroutines.flow.Flow

class LocalUserRepository(private val userDao: UserDao) : UserRepository {
    override fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    override fun getUserById(id: Int): Flow<User?> {
        return userDao.getUserById(id)
    }

    override suspend fun upsertUser(user: User) {
        return userDao.upsert(user)
    }

    override suspend fun deleteUser(user: User) {
        return userDao.delete(user)
    }

    override suspend fun deleteByName(name: String) {
        return userDao.deleteByName(name)
    }
}