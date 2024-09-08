package com.example.trailquest.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.trailquest.TrailQuestApplication
import com.example.trailquest.ui.screens.attraction_screen.AttractionScreenViewModel
import com.example.trailquest.ui.screens.country_screen.CountryScreenViewModel
import com.example.trailquest.ui.screens.profile_screen.UserProfileScreenViewModel
import com.example.trailquest.ui.screens.statistics_screen.StatisticsScreenViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            UserProfileScreenViewModel(
                trailQuestApplication().container.usersRepository,
                trailQuestApplication().container.attractionRepository,
                trailQuestApplication().container.countryRepository,
                trailQuestApplication().container.typeRepository
            )
        }
        initializer {
            AttractionScreenViewModel(
                trailQuestApplication().container.attractionRepository
            )
        }
        initializer {
            CountryScreenViewModel(
                trailQuestApplication().container.countryRepository,
                trailQuestApplication().container.attractionRepository,
                trailQuestApplication().container.typeRepository
            )
        }
        initializer {
            StatisticsScreenViewModel(
                trailQuestApplication().container.countryRepository,
                trailQuestApplication().container.attractionRepository,
                trailQuestApplication().container.typeRepository
            )
        }
    }
}

fun CreationExtras.trailQuestApplication(): TrailQuestApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as TrailQuestApplication)