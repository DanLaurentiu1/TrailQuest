package com.example.trailquest.ui.screens.profile_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trailquest.data.repository.attraction.AttractionRepository
import com.example.trailquest.data.repository.country.CountryRepository
import com.example.trailquest.data.repository.type.TypeRepository
import com.example.trailquest.data.repository.user.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserProfileScreenViewModel(
    private val usersRepository: UserRepository,
    private val attractionRepository: AttractionRepository,
    private val countryRepository: CountryRepository,
    private val typeRepository: TypeRepository,
) : ViewModel() {
    var uiState = MutableStateFlow(UserProfileScreenUiState())
        private set

    init {
        uiState.value = UserProfileScreenUiState()
    }

    fun initProfile() {
        viewModelScope.launch {

            val user = usersRepository.getAllUsers().first().first()

            val numberAttractions = attractionRepository.getTotalNumberOfAttractions().first()

            val completedAttractions =
                attractionRepository.getNumberOfCompletedAttractions().first()

            val mostLikedThreeCountiesNames: MutableList<String> = mutableListOf()
            countryRepository.getMostCompletedCountry(3).first().forEach { id ->
                mostLikedThreeCountiesNames += countryRepository.getCountryById(id)
                    .first().name
            }

            val mostLikedThreeActivityNames: MutableList<String> = mutableListOf()
            attractionRepository.getMostLikedActivities(3).first().forEach { id ->
                mostLikedThreeActivityNames += typeRepository.getTypeById(id)
                    .first().name
            }

            uiState.update {
                it.copy(
                    userName = user.name,
                    userTitle = user.title,
                    userLevel = user.level,
                    bioText = user.bio,
                    attractionsCompleted = completedAttractions,
                    attractionTotal = numberAttractions,
                    mostLikedActivities = mostLikedThreeActivityNames,
                    mostLikedCountries = mostLikedThreeCountiesNames
                )
            }
        }
    }
}