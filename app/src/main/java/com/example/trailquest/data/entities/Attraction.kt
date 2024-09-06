package com.example.trailquest.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Attractions")
data class Attraction(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val completed: Boolean
    // @DrawableRes val image: Int
)