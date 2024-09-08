package com.example.trailquest.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.trailquest.ui.AppViewModelProvider
import com.example.trailquest.ui.screens.attraction_screen.AttractionScreen
import com.example.trailquest.ui.screens.attraction_screen.AttractionScreenViewModel
import com.example.trailquest.ui.screens.country_screen.CountryScreen
import com.example.trailquest.ui.screens.country_screen.CountryScreenViewModel
import com.example.trailquest.ui.screens.main_screen.MainScreen
import com.example.trailquest.ui.screens.profile_screen.UserProfileScreen
import com.example.trailquest.ui.screens.profile_screen.UserProfileScreenViewModel
import com.example.trailquest.ui.screens.statistics_screen.StatisticsScreen
import com.example.trailquest.ui.screens.statistics_screen.StatisticsScreenViewModel

@Composable
fun TrailQuestNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = MainScreenClass,
        modifier = modifier,
        enterTransition = {
            scaleIn(
                animationSpec = tween(235),
                initialScale = 0.9f
            ) + fadeIn(animationSpec = tween(235))
        },
        exitTransition = {
            scaleOut(
                animationSpec = tween(
                    durationMillis = 150,
                ), targetScale = 0.9f
            ) + fadeOut()
        }
    ) {
        composable<MainScreenClass> {
            MainScreen(
                viewModel = viewModel(),
                onHomeClicked = {
                    navController.popBackStack(
                        MainScreenClass,
                        inclusive = false
                    )
                },
                onStatisticsClicked = {
                    navController.navigate(StatisticsScreenClass)
                },
                onProfileClicked = {
                    navController.navigate(
                        UserProfileScreenClass
                    )
                },
                onCountrySelected = { countryName ->
                    navController.navigate(CountryScreenClass(countryName = countryName))
                }
            )
        }

        composable<UserProfileScreenClass> {
            val viewModel: UserProfileScreenViewModel =
                viewModel(factory = AppViewModelProvider.Factory)
            viewModel.initProfile()
            UserProfileScreen(
                onBackClicked = { navController.navigateUp() },
                onHomeClicked = {
                    navController.popBackStack(
                        MainScreenClass,
                        inclusive = false
                    )
                },
                onProfileClicked = {
                    navController.navigate(
                        UserProfileScreenClass
                    )
                },
                onStatisticsClicked = { navController.navigate(StatisticsScreenClass) },
                viewModel = viewModel
            )
        }

        composable<CountryScreenClass> { backStackEntry ->
            val params = backStackEntry.toRoute<CountryScreenClass>()
            val viewModel: CountryScreenViewModel =
                viewModel(factory = AppViewModelProvider.Factory)
            viewModel.initCountry(countryName = params.countryName)
            CountryScreen(
                onBackClicked = { navController.navigateUp() },
                onHomeClicked = {
                    navController.popBackStack(
                        MainScreenClass,
                        inclusive = false
                    )
                },
                onAttractionClicked = { attractionName ->
                    navController.navigate(
                        AttractionScreenClass(
                            attractionName = attractionName
                        )
                    )
                },
                viewModel = viewModel
            )
        }

        composable<AttractionScreenClass> { backStackEntry ->
            val params = backStackEntry.toRoute<AttractionScreenClass>()
            val viewModel: AttractionScreenViewModel =
                viewModel(factory = AppViewModelProvider.Factory)
            viewModel.initAttraction(attractionName = params.attractionName)
            AttractionScreen(
                onHomeClicked = {
                    navController.popBackStack(
                        MainScreenClass,
                        inclusive = false
                    )
                },
                onBackClicked = { navController.navigateUp() },
                onStatisticsClicked = { navController.navigate(StatisticsScreenClass) },
                onProfileClicked = {
                    navController.navigate(
                        UserProfileScreenClass
                    )
                },
                viewModel = viewModel
            )
        }

        composable<StatisticsScreenClass> {
            val viewModel: StatisticsScreenViewModel =
                viewModel(factory = AppViewModelProvider.Factory)
            viewModel.initStatistics()
            StatisticsScreen(
                onBackClicked = { navController.navigateUp() },
                onHomeClicked = {
                    navController.popBackStack(
                        MainScreenClass,
                        inclusive = false
                    )
                },
                viewModel = viewModel
            )
        }
    }
}