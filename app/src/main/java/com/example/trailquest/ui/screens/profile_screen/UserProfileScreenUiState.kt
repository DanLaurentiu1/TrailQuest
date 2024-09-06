package com.example.trailquest.ui.screens.profile_screen

data class UserProfileScreenUiState(
    val userName: String = "Lau",
    val attractionsCompleted: Float = 19f,
    val attractionTotal: Float = 100f,
    val userTitle: String = "Newbie",
    val userLevel: Int = 1,
    val bioText: String = "I don't know",
    val mostLikedCountries: List<String> = listOf(""),
    val mostLikedActivities: List<String> = listOf("")
)