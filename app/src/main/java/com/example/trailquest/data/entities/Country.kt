package com.example.trailquest.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Countries")
data class Country(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val visitors: Int,
    val stars: Float
)