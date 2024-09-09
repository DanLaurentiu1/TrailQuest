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

    private suspend fun getAllAttractionsFromCountry(countryName: String): List<Attraction> {
        return attractionRepository.getAttractionsByCountryName(countryName).first()
    }


    fun createAttraction(
        attractionName: String,
        attractionAboutText: String,
        countryName: String,
        typeId: Int
    ) {
        // delete attraction
        viewModelScope.launch {
            attractionRepository.upsert(
                Attraction(
                    name = attractionName,
                    description = attractionAboutText,
                    completed = false,
                    countryId = countryRepository.getCountryByName(countryName).first().id,
                    typeId = typeId
                )
            )
        }
        // refresh uiState
        initCountry(uiState.value.countryName)
    }

    fun deleteAttraction(
        attractionName: String
    ) {
        viewModelScope.launch {
            val attraction = attractionRepository.getAttractionByName(attractionName).first()
            attractionRepository.delete(attraction)
        }
        initCountry(uiState.value.countryName)
    }

    fun initCountry(countryName: String) {
        viewModelScope.launch {
            // get the specific country
            val country = getCountryFromDatabase(countryName)

            // get all types
            val allTypes = getAllTypes()

            // get all the attractions belonging to those types and this country
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