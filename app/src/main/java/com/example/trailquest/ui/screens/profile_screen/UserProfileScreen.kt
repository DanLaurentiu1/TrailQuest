package com.example.trailquest.ui.screens.profile_screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trailquest.R
import com.example.trailquest.data.datasource.DataSources
import com.example.trailquest.ui.theme.TrailQuestAppTheme

@Composable
fun UserProfileScreen() {

}

@Composable
fun NavigationRailIcon(@DrawableRes image: Int) {
    Image(painter = painterResource(image), contentDescription = "")
}

@Composable
fun CustomNavigationRail() {
    NavigationRail(
        modifier = Modifier
            .height(dimensionResource(R.dimen.navigation_rail_height))
    ) {
        DataSources.navigationRailItems.forEach { (key, value) ->
            NavigationRailItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = { NavigationRailIcon(value) },
                label = { Text(text = key) },
                modifier = Modifier.padding(
                    dimensionResource(R.dimen.padding_very_small)
                )
            )
        }
    }
}

@Composable
fun ProfilePicture() {
    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.android_superhero2), contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    dimensionResource(R.dimen.profile_picture_border_width),
                    MaterialTheme.colorScheme.secondary,
                    CircleShape
                )
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
        Text(text = "HogRida", style = MaterialTheme.typography.displayMedium)
    }
}

@Composable
fun ProfileStats() {
    Row {

    }
}

@Composable
fun AboutMeSection() {

}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    TrailQuestAppTheme {
        ProfilePicture()
    }
}