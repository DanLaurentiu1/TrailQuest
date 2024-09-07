package com.example.trailquest.ui.screens.statistics_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trailquest.data.entities.Country
import com.example.trailquest.data.entities.Type
import com.example.trailquest.data.repository.attraction.AttractionRepository
import com.example.trailquest.data.repository.country.CountryRepository
import com.example.trailquest.data.repository.type.TypeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StatisticsScreenViewModel(
    private val countryRepository: CountryRepository,
    private val attractionRepository: AttractionRepository,
    private val typeRepository: TypeRepository
) : ViewModel() {
    var uiState = MutableStateFlow(StatisticsScreenUiState())
        private set

    init {
        uiState.value = StatisticsScreenUiState()
    }

    private suspend fun getNumberOfCompletedAttractionsByType(typeId: Int): Float {
        return attractionRepository.getNumberOfCompletedAttractionsByType(typeId = typeId).first()
    }

    private suspend fun getNumberOfTotalAttractionsByType(typeId: Int): Float {
        return attractionRepository.getNumberOfTotalAttractionsByType(typeId = typeId).first()
    }

    private suspend fun getNumberOfCompletedAttractionsByTypeAndCountry(
        typeId: Int,
        countryId: Int
    ): Float {
        return attractionRepository.getNumberOfCompletedAttractionsByTypeAndCountry(
            typeId = typeId,
            countryId = countryId
        ).first()
    }

    private suspend fun getNumberOfTotalAttractionsByTypeAndCountry(
        typeId: Int,
        countryId: Int
    ): Float {
        return attractionRepository.getNumberOfTotalAttractionsByTypeAndCountry(
            typeId = typeId,
            countryId = countryId
        ).first()
    }

    private suspend fun getAllCountries(): List<Country> {
        return countryRepository.getAllCountries().first()
    }

    private suspend fun getAllTypes(): List<Type> {
        return typeRepository.getAllTypes().first()
    }

    private suspend fun getOverallStatistics(): HashMap<Type, Array<Float>> {
        val overallHashMap: HashMap<Type, Array<Float>> = hashMapOf()
        val allTypes = getAllTypes()
        allTypes.forEach { type ->
            overallHashMap[type] = arrayOf(0f, 0f)
            overallHashMap[type]!![0] = getNumberOfCompletedAttractionsByType(
                typeId = type.id
            )
            overallHashMap[type]!![1] = getNumberOfTotalAttractionsByType(type.id)
        }
        return overallHashMap
    }

    private suspend fun getCountryStatistics(countryId: Int): HashMap<Type, Array<Float>> {
        val allTypes = getAllTypes()
        val countryHashMap: HashMap<Type, Array<Float>> = hashMapOf()
        allTypes.forEach { type ->
            countryHashMap[type] = arrayOf(0f, 0f)
            countryHashMap[type]!![0] = getNumberOfCompletedAttractionsByTypeAndCountry(
                typeId = type.id,
                countryId = countryId
            )
            countryHashMap[type]!![1] = getNumberOfTotalAttractionsByTypeAndCountry(
                typeId = type.id,
                countryId = countryId
            )
        }
        return countryHashMap
    }

    fun resetUiState() {
        viewModelScope.launch {
            val statistics: HashMap<String, HashMap<Type, Array<Float>>> = hashMapOf()
            val allCountries = getAllCountries()
            allCountries.forEach { country ->
                statistics[country.name] = getCountryStatistics(country.id)
            }
            statistics["Overall"] = getOverallStatistics()
            uiState.update {
                it.copy(
                    statistics = statistics,
                    allCountries = allCountries
                )
            }
        }
    }
}