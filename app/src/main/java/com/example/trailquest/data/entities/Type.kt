package com.example.trailquest.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Types")
data class Type(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)
