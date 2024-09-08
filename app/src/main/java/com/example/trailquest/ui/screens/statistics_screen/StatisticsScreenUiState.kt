package com.example.trailquest.ui.screens.statistics_screen

import com.example.trailquest.data.entities.Country
import com.example.trailquest.data.entities.Type


data class StatisticsScreenUiState(
    val statistics: HashMap<String, HashMap<Type, Array<Int>>> = hashMapOf(),
    val allCountries: List<Country> = listOf()
)