package com.example.trailquest.ui.reusable_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.trailquest.R

@Preview
@Composable
fun GoBackAppBarPreview() {
    AppTheme {
        GoBackTopAppBar(goBackOnClick = {}, goHomeOnClick = {})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoBackTopAppBar(
    goBackOnClick: () -> Unit,
    goHomeOnClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            titleContentColor = MaterialTheme.colorScheme.secondary,
        ),
        title = {
            Text(
                stringResource(R.string.navigation_bar_title),
                style = MaterialTheme.typography.headlineMedium
            )
        },
        navigationIcon = {
            IconButton(
                onClick = goBackOnClick,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.hsl(0f, 0f, 0.95f))
                    .width(dimensionResource(R.dimen.navigation_top_bar_button_width))
                    .height(dimensionResource(R.dimen.navigation_top_bar_button_height)),
            ) {
                NavigationIcon(icon = R.drawable.rounded_arrow_back_24, onClick = goBackOnClick)
            }
        },
        actions = {
            IconButton(
                onClick = goBackOnClick,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.hsl(0f, 0f, 0.95f))
                    .width(dimensionResource(R.dimen.navigation_top_bar_button_width))
                    .height(dimensionResource(R.dimen.navigation_top_bar_button_height)),
            ) {
                NavigationIcon(icon = R.drawable.rounded_home_24, onClick = goHomeOnClick)
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    )
}