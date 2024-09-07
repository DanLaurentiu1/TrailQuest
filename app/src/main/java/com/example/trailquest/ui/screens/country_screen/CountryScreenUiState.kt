package com.example.trailquest.ui.screens.country_screen

import com.example.trailquest.data.entities.Attraction
import com.example.trailquest.data.entities.Type

data class CountryScreenUiState(
    val countryName: String = "",
    val countryStars: Float = 0f,
    val countryVisitors: Int = 0,
    val countryAttractions: HashMap<Type, List<Attraction>> = hashMapOf()
)