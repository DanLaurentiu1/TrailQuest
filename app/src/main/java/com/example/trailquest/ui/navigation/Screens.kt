package com.example.trailquest.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainScreenClass

@Serializable
data class CountryScreenClass(
    val countryName: String
)

@Serializable
data class AttractionScreenClass(
    val attractionName: String
)

@Serializable
data class UserProfileScreenClass(
    val userName: String = "Lau",
    val attractionsCompleted: Float = 0f,
    val attractionTotal: Float = 0f,
    val userTitle: String = "",
    val userLevel: Int = 0,
    val bioText: String = "",
    val mostLikedCountries: List<String> = listOf(),
    val mostLikedActivities: List<String> = listOf()
)

@Serializable
object StatisticsScreenClass