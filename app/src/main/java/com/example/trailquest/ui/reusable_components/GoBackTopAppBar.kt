package com.example.trailquest.ui.reusable_components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.trailquest.R
import com.example.trailquest.ui.theme.TrailQuestAppTheme

@Preview
@Composable
fun GoBackAppBarPreview() {
    TrailQuestAppTheme {
        GoBackTopAppBar()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoBackTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "TrailQuest", style = MaterialTheme.typography.displaySmall
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                NavigationIcon(icon = R.drawable.rounded_arrow_back_24)
            }
        },
        actions = {
            IconButton(onClick = { }) {
                NavigationIcon(icon = R.drawable.profile_picture_icon)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        )
    )
}