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
object UserProfileScreenClass

@Serializable
object StatisticsScreenClass