package com.example.trailquest.ui.screens.statistics_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class StatisticsScreenViewModel : ViewModel() {
    var uiState = MutableStateFlow(StatisticsScreenUiState())
        private set

    init {
        //Database
        uiState.value = StatisticsScreenUiState()

        // query for getting the user Data
        // setUiState with the data that I am getting
    }

    fun setUiState(
        statistics: HashMap<String, HashMap<String, Array<Float>>>
    ) {
        uiState.update {
            it.copy(
                statistics = statistics
            )
        }
    }
}