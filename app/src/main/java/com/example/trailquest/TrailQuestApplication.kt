package com.example.trailquest

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trailquest.ui.navigation.TrailQuestNavHost

@Composable
fun TrailQuestApplication(navController: NavHostController = rememberNavController()) {
    TrailQuestNavHost(navController = navController)
}