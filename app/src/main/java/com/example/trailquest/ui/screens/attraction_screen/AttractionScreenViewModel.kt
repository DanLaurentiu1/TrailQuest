package com.example.trailquest.ui.screens.attraction_screen

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class AttractionScreenViewModel : ViewModel() {
    var uiState = MutableStateFlow(AttractionScreenUiState())
        private set

    init {
        //Database
        uiState.value = AttractionScreenUiState()

        // query for getting the user Data
        // setUiState with the data that I am getting
    }

    fun setUiState(
        attractionName: String = "",
        @DrawableRes attractionPicture: Int = 0,
        aboutText: String = "",
        isCompleted: Boolean = false
    ) {
        uiState.update {
            it.copy(
                attractionName = attractionName,
                attractionPicture = attractionPicture,
                aboutText = aboutText,
                isCompleted = isCompleted
            )
        }
    }
}