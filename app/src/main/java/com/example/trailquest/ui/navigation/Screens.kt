package com.example.trailquest.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainScreenClass

// need to pass the name for each country in order for me to be able to find it from db
@Serializable
data class CountryScreenClass(
    val countryName: String
)

// need to pass the name for each attraction in order for me to be able to find it from db
@Serializable
data class AttractionScreenClass(
    val attractionName: String
)

@Serializable
object UserProfileScreenClass

@Serializable
object StatisticsScreenClass