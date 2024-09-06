package com.example.trailquest.ui.screens.attraction_screen

import androidx.annotation.DrawableRes

data class AttractionScreenUiState(
    val attractionName: String = "",
    @DrawableRes val attractionPicture: Int = 0,
    val aboutText: String = "",
    val isCompleted: Boolean = false
)