package com.example.trailquest.ui.screens.profile_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trailquest.data.repository.attraction.AttractionRepository
import com.example.trailquest.data.repository.user.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserProfileScreenViewModel(
    private val usersRepository: UserRepository,
    private val attractionRepository: AttractionRepository,
) : ViewModel() {
    var uiState = MutableStateFlow(UserProfileScreenUiState())
        private set

    init {
        //Database
        uiState.value = UserProfileScreenUiState()
        /*
        viewModelScope.launch {
            attractionRepository.upsert()
        }
         */
    }

    fun initProfile() {
        viewModelScope.launch {
            val user = usersRepository.getAllUsers().first().first()
            val numberAttractions = attractionRepository.getTotalNumberOfAttractions().first()
            val completedAttractions =
                attractionRepository.getNumberOfCompletedAttractions().first()

            uiState.update {
                it.copy(
                    userName = user.name,
                    userTitle = user.title,
                    userLevel = user.level,
                    bioText = user.bio,
                    attractionsCompleted = completedAttractions,
                    attractionTotal = numberAttractions,
                    mostLikedActivities = listOf(),
                    mostLikedCountries = listOf()
                )
            }
        }
    }
}