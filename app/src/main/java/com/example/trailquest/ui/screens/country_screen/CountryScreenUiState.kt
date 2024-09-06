package com.example.trailquest.ui.screens.country_screen

data class CountryScreenUiState(
    val countryName: String = "",
    val countryStars: Int = 0,
    val countryVisitors: Int = 0,
    val countryAttractionTypes: List<String> = listOf(),
    val countryAttractions: List<String> = listOf(),
)