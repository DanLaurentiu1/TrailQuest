package com.example.trailquest.ui.screens.attraction_screen

import androidx.annotation.DrawableRes

data class AttractionScreenUiState(
    val attractionId: Int = 0,
    val attractionName: String = "",
    val aboutText: String = "",
    val isCompleted: Boolean = false,
    val countryId: Int = 0,
    val typeId: Int = 0
)