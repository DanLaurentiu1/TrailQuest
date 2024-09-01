package com.example.trailquest.ui.screens.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trailquest.R
import com.example.trailquest.ui.reusable_components.CustomNavigationBar
import com.example.trailquest.ui.reusable_components.GoBackTopAppBar
import com.example.trailquest.ui.reusable_components.ProgressBar
import com.example.trailquest.ui.theme.TrailQuestAppTheme

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    TrailQuestAppTheme {
        UserProfileScreen()
    }
}

@Composable
fun UserProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        GoBackTopAppBar()
        Card(
            onClick = { }, modifier = Modifier
                .padding(12.dp)
                .weight(1f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_very_small), top = 21.dp)
                    .fillMaxHeight()
            ) {
                ProfilePicture()
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "HogRida", style = MaterialTheme.typography.displaySmall,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    TitleAndLevelSection()
                }
            }
        }
        BioSection(modifier = Modifier.weight(1.75f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.25f)
        ) {
            MostLikedCountriesSection(modifier = Modifier.weight(1f))
            MostLikedActivitiesSection(modifier = Modifier.weight(1f))
        }
        CustomNavigationBar()
    }
}

@Composable
fun ProfilePicture() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.android_superhero2), contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    dimensionResource(R.dimen.profile_picture_border_width),
                    MaterialTheme.colorScheme.secondary,
                    CircleShape
                )
                .width(110.dp)
                .height(110.dp)
        )
    }
}

@Composable
fun TitleAndLevelSection() {
    Column(
        modifier = Modifier
            .padding(top = 6.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Adventurer, level 6", style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        ProgressBar()
    }
}

@Composable
fun BioSection(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(
            text = "Bio",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = "BioBioBioBio BioBioBioBio  BioBio Bio BioBioBio Bio Bio BioBioBioBioBio",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(10.dp)
        )

    }
}

@Composable
fun MostLikedCountriesSection(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxHeight()
    ) {
        Text(
            text = "Most Liked Countries",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(10.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Albania")
            Text(text = "Albania")
            Text(text = "Albania")
        }
    }
}

@Composable
fun MostLikedActivitiesSection(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(12.dp)
            .fillMaxHeight()
    ) {
        Text(
            text = "Most Liked Attractions",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(10.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Zoos")
            Text(text = "Beaches")
            Text(text = "Nature")
        }
    }

}