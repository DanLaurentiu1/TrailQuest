package com.example.trailquest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.trailquest.ui.screens.main_screen.MainScreen
import com.example.trailquest.ui.screens.profile_screen.UserProfileScreen

@Composable
fun TrailQuestNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = MainScreenClass,
        modifier = modifier
    ) {
        composable<MainScreenClass> {
            MainScreen(
                onSearchClick = { },
                onQueryChange = { },
                onActiveChange = { },
                isSearchBarActive = false,
                isHomeSelected = false,
                isStatisticsSelected = false,
                isProfileSelected = false,
                onHomeClicked = { },
                onStatisticsClicked = {
                    navController.navigate(
                        UserProfileScreenClass(
                            userName = "HogRidaa",
                            attractionsCompleted = 40f,
                            attractionTotal = 123f,
                            userTitle = "Adventurer",
                            userLevel = 6,
                            bioText = "I don't know",
                            mostLikedCountries = listOf("Albania", "France", "Belgium"),
                            mostLikedActivities = listOf("Zoo", "Nature", "Food")
                        )
                    )
                },
                onProfileClicked = {}
            )
        }

        composable<UserProfileScreenClass> {
            val args = it.toRoute<UserProfileScreenClass>()
            UserProfileScreen(
                onBackButtonClick = { },
                onHomeButtonClick = { },
                onProfileButtonClick = { },
                onStatisticsButtonClick = { },
                userName = args.userName,
                attractionsCompleted = args.attractionsCompleted,
                attractionTotal = args.attractionTotal,
                userTitle = args.userTitle,
                userLevel = args.userLevel,
                bioText = args.bioText,
                mostLikedCountries = args.mostLikedCountries,
                mostLikedActivities = args.mostLikedActivities
            )
        }
    }
}

