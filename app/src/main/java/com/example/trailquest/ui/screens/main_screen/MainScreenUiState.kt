package com.example.trailquest.ui.screens.main_screen

data class MainScreenUiState(
    val isSearchBarActive: Boolean = false,
    val isHomeSelected: Boolean = false,
    val isStatisticsSelected: Boolean = false,
    val isProfileSelected: Boolean = false,
    val searchBarQuery: String = ""
)