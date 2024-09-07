package com.example.trailquest.ui.screens.country_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trailquest.data.entities.Attraction
import com.example.trailquest.data.entities.Country
import com.example.trailquest.data.entities.Type
import com.example.trailquest.data.repository.attraction.AttractionRepository
import com.example.trailquest.data.repository.country.CountryRepository
import com.example.trailquest.data.repository.type.TypeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountryScreenViewModel(
    private val countryRepository: CountryRepository,
    private val attractionRepository: AttractionRepository,
    private val typeRepository: TypeRepository
) : ViewModel() {
    var uiState = MutableStateFlow(CountryScreenUiState())
        private set

    init {
        uiState.value = CountryScreenUiState()
    }

    private suspend fun getCountryFromDatabase(countryName: String): Country {
        return countryRepository.getCountryByName(countryName).first()
    }

    private suspend fun getAttractionsByCountryAndType(
        countryId: Int,
        typeId: Int
    ): List<Attraction> {
        return attractionRepository.getAttractionsByCountryAndType(
            countryId = countryId,
            typeId = typeId
        ).first()
    }

    private suspend fun getAllTypes(): List<Type> {
        return typeRepository.getAllTypes().first()
    }

    fun resetUiState(countryName: String) {
        viewModelScope.launch {
            val country = getCountryFromDatabase(countryName)
            val allTypes = getAllTypes()
            val attractionDict: HashMap<Type, List<Attraction>> = hashMapOf()
            allTypes.forEach { type ->
                val attractionsForThisTypeAndCountry =
                    getAttractionsByCountryAndType(countryId = country.id, typeId = type.id)
                attractionDict[type] = attractionsForThisTypeAndCountry
            }
            uiState.update {
                it.copy(
                    countryName = country.name,
                    countryVisitors = country.visitors,
                    countryStars = country.stars,
                    countryAttractions = attractionDict
                )
            }
        }
    }
}