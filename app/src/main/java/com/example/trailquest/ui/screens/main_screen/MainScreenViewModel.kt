package com.example.trailquest.ui.screens.main_screen

import androidx.lifecycle.ViewModel
import com.example.trailquest.data.DataSources
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainScreenViewModel : ViewModel() {
    var uiState = MutableStateFlow(MainScreenUiState())
        private set

    init {
        uiState.value = MainScreenUiState()
    }

    fun updateSearchBarQuery(newQuery: String) {
        uiState.update {
            it.copy(
                searchBarQuery = newQuery
            )
        }
    }

    fun searchClick(): Boolean {
        if (this.uiState.value.searchBarQuery in DataSources.countries) {
            return true
        } else {
            resetSearchBarQuery()
            return false
        }
    }

    // when the search bar query was wrong
    private fun resetSearchBarQuery() {
        updateSearchBarQuery("")
    }
}