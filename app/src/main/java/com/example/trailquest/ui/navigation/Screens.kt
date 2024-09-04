package com.example.trailquest.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainScreenClass


@Serializable
data class CountryScreenClass(
    val countryName: String,
    val visitors: Int
)

@Serializable
data class AttractionScreenClass(
    val attractionTitle: String,
    val aboutText: String,
    val isChecked: Boolean,
)

@Serializable
data class UserProfileScreenClass(
    val userName: String,
    val attractionsCompleted: Float,
    val attractionTotal: Float,
    val userTitle: String,
    val userLevel: Int,
    val bioText: String,
    val mostLikedCountries: List<String>,
    val mostLikedActivities: List<String>
)