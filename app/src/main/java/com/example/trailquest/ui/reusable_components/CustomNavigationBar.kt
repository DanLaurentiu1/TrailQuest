package com.example.trailquest.ui.reusable_components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.trailquest.R

@Preview(showBackground = true)
@Composable
fun CustomNavigationBarPreview() {
    AppTheme {
        CustomNavigationBar(
            modifier = Modifier,
            isHomeSelected = false,
            isStatisticsSelected = false,
            isProfileSelected = false,
            onHomeClicked = {},
            onStatisticsClicked = {},
            onProfileClicked = {}
        )
    }
}

@Composable
fun CustomNavigationBar(
    modifier: Modifier,
    isHomeSelected: Boolean,
    isStatisticsSelected: Boolean,
    isProfileSelected: Boolean,
    onHomeClicked: () -> Unit,
    onStatisticsClicked: () -> Unit,
    onProfileClicked: () -> Unit
) {
    NavigationBar(
        modifier = modifier
            .clip(
                RoundedCornerShape(dimensionResource(R.dimen.navigation_bar_clip_size))
            )
    ) {
        Row {
            NavigationBarItem(
                selected = isHomeSelected,
                onClick = onHomeClicked,
                icon = { NavigationIcon(R.drawable.rounded_home_24, onClick = onHomeClicked) },
                label = {
                    Text(
                        text = stringResource(R.string.navigation_bar_home_text),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                })
            NavigationBarItem(
                selected = isStatisticsSelected,
                onClick = onStatisticsClicked,
                icon = {
                    NavigationIcon(
                        R.drawable.statistics_icon,
                        onClick = onStatisticsClicked
                    )
                },
                label = {
                    Text(
                        text = stringResource(R.string.navigation_bar_home_statistics),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                })
            NavigationBarItem(
                selected = isProfileSelected,
                onClick = onProfileClicked,
                icon = {
                    NavigationIcon(
                        R.drawable.profile_picture_icon,
                        onClick = onProfileClicked
                    )
                },
                label = {
                    Text(
                        text = stringResource(R.string.navigation_bar_home_profile),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                })
        }
    }
}