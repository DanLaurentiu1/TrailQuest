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
            // get the first user (me)
            val user = usersRepository.getAllUsers().first().first()

            // get number of attractions (stats)
            val numberAttractions = attractionRepository.getTotalNumberOfAttractions().first()

            // get completed attractions (stats)
            val completedAttractions =
                attractionRepository.getNumberOfCompletedAttractions().first()

            // get top 3 country names by number of completed attractions belonging to these countries
            val mostLikedThreeCountiesNames: MutableList<String> = mutableListOf()
            countryRepository.getMostCompletedCountry(3).first().forEach { id ->
                mostLikedThreeCountiesNames += countryRepository.getCountryById(id)
                    .first().name
            }

            // get top 3 type names by number of completed attractions belonging to these types
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