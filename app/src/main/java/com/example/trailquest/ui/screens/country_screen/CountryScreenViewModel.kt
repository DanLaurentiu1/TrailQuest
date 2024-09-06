package com.example.trailquest.ui.screens.country_screen

import androidx.lifecycle.ViewModel
import com.example.trailquest.data.repository.country.CountryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class CountryScreenViewModel(countryRepository: CountryRepository) : ViewModel() {
    var uiState = MutableStateFlow(CountryScreenUiState())
        private set

    init {
        //Database
        uiState.value = CountryScreenUiState()

        // query for getting the user Data
        // setUiState with the data that I am getting
    }

    fun setUiState(
        countryName: String = "",
        countryStars: Int = 0,
        countryVisitors: Int = 0,
        countryAttractionTypes: List<String> = listOf(),
        countryAttractions: List<String> = listOf(),
    ) {
        uiState.update {
            it.copy(
                countryName = countryName,
                countryStars = countryStars,
                countryVisitors = countryVisitors,
                countryAttractions = countryAttractions,
                countryAttractionTypes = countryAttractionTypes
            )
        }
    }
}