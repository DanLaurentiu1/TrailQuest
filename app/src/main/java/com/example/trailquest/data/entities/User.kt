package com.example.trailquest.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val level: Int,
    val title: String,
    val bio: String
    // @DrawableRes val profilePic: Int
)