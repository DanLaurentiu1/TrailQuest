package com.example.trailquest.ui.reusable_components

import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.trailquest.R


@Composable
fun StatisticsButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = dimensionResource(R.dimen.floating_action_button_elevation))
    ) {
        Icon(painter = painterResource(R.drawable.statistics_icon), contentDescription = "")
    }
}