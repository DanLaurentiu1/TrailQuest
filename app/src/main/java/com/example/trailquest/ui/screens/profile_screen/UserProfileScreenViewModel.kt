package com.example.trailquest.ui.screens.profile_screen

import androidx.lifecycle.ViewModel
import com.example.trailquest.data.repository.user.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class UserProfileScreenViewModel(
    usersRepository: UserRepository,
) : ViewModel() {
    var uiState = MutableStateFlow(UserProfileScreenUiState())
        private set

    init {
        //Database
        uiState.value = UserProfileScreenUiState()
    }

    // query for getting the user Data
    // setUiState with the data that I am getting
    fun setUiState(
        userName: String = "Lau",
        attractionsCompleted: Float = 19f,
        attractionTotal: Float = 100f,
        userTitle: String = "Newbie",
        userLevel: Int = 1,
        bioText: String = "I don't know",
        mostLikedCountries: List<String> = listOf(""),
        mostLikedActivities: List<String> = listOf("")
    ) {
        uiState.update {
            it.copy(
                userName = userName,
                attractionsCompleted = attractionsCompleted,
                attractionTotal = attractionTotal,
                userTitle = userTitle,
                userLevel = userLevel,
                bioText = bioText,
                mostLikedCountries = mostLikedCountries,
                mostLikedActivities = mostLikedActivities
            )
        }
    }

}