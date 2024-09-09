package com.example.trailquest.ui.screens.attraction_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trailquest.data.entities.Attraction
import com.example.trailquest.data.repository.attraction.AttractionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AttractionScreenViewModel(private val attractionRepository: AttractionRepository) :
    ViewModel() {
    var uiState = MutableStateFlow(AttractionScreenUiState())
        private set

    init {
        uiState.value = AttractionScreenUiState()
    }

    private suspend fun getAttractionByName(attractionName: String): Attraction {
        return attractionRepository.getAttractionByName(attractionName).first()
    }

    fun checkAttraction() {
        // add attraction then refresh UI (need to collect and emit flows for better performance)
        viewModelScope.launch {
            attractionRepository.upsert(
                Attraction(
                    id = uiState.value.attractionId,
                    name = uiState.value.attractionName,
                    description = uiState.value.aboutText,
                    completed = !uiState.value.isCompleted,
                    countryId = uiState.value.countryId,
                    typeId = uiState.value.typeId
                )
            )
        }
        // refresh uiState
        initAttraction(attractionName = uiState.value.attractionName)
    }

    fun initAttraction(attractionName: String) {
        viewModelScope.launch {
            uiState.update {
                val attraction = getAttractionByName(attractionName)
                it.copy(
                    attractionId = attraction.id,
                    attractionName = attraction.name,
                    isCompleted = attraction.completed,
                    aboutText = attraction.description,
                    countryId = attraction.countryId,
                    typeId = attraction.typeId
                )
            }
        }
    }
}