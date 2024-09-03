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
        CustomNavigationBar()
    }
}

@Composable
fun CustomNavigationBar() {
    NavigationBar(
        modifier = Modifier
            .clip(
                RoundedCornerShape(dimensionResource(R.dimen.navigation_bar_clip_size))
            )
    ) {
        Row(
            modifier = Modifier,
        ) {
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = { NavigationIcon(R.drawable.rounded_home_24, onClick = {}) },
                label = {
                    Text(
                        text = stringResource(R.string.navigation_bar_home_text),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                })
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = { NavigationIcon(R.drawable.statistics_icon, onClick = {}) },
                label = {
                    Text(
                        text = stringResource(R.string.navigation_bar_home_statistics),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                })
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = { NavigationIcon(R.drawable.profile_picture_icon, onClick = {}) },
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