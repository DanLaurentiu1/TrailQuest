package com.example.trailquest.ui.screens.profile_screen

data class UserProfileScreenUiState(
    val userName: String = "Lau",
    val attractionsCompleted: Int = 19,
    val attractionTotal: Int = 100,
    val userTitle: String = "Newbie",
    val userLevel: Int = 1,
    val bioText: String = "I don't know",
    val mostLikedCountries: List<String> = listOf(""),
    val mostLikedActivities: List<String> = listOf("")
)