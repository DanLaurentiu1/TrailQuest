package com.example.trailquest.ui.screens.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.trailquest.R
import com.example.trailquest.ui.reusable_components.CustomNavigationBar
import com.example.trailquest.ui.reusable_components.GoBackTopAppBar
import com.example.trailquest.ui.reusable_components.ProgressBar

@Preview
@Composable
fun UserProfileScreenPreview() {
    AppTheme {
        UserProfileScreen(
            onBackButtonClick = { },
            onHomeButtonClick = { },
            onProfileButtonClick = { },
            onStatisticsButtonClick = { },
            userName = "HogRidaa",
            attractionsCompleted = 40f,
            attractionTotal = 123f,
            userTitle = "Adventurer",
            userLevel = 6,
            bioText = "I don't know",
            mostLikedCountries = listOf("Albania", "France", "Belgium"),
            mostLikedActivities = listOf("Zoo", "Nature", "Food")
        )
    }
}

@Composable
fun UserProfileScreen(
    modifier: Modifier = Modifier,
    onBackButtonClick: () -> Unit,
    onHomeButtonClick: () -> Unit,
    onProfileButtonClick: () -> Unit,
    onStatisticsButtonClick: () -> Unit,
    userName: String,
    attractionsCompleted: Float,
    attractionTotal: Float,
    userTitle: String,
    userLevel: Int,
    bioText: String,
    mostLikedCountries: List<String>,
    mostLikedActivities: List<String>
) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.onPrimary)) {
        GoBackTopAppBar(goBackOnClick = onBackButtonClick, goHomeOnClick = onHomeButtonClick)
        ElevatedCard(
            onClick = { }, modifier = Modifier
                .padding(dimensionResource(R.dimen.user_profile_screen_card_padding))
                .weight(1f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        dimensionResource(R.dimen.padding_very_small),
                        top = dimensionResource(R.dimen.user_profile_screen_card_row_padding_top)
                    )
                    .fillMaxHeight()
            ) {
                ProfilePicture()
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = userName, style = MaterialTheme.typography.displaySmall,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold
                    )
                    TitleAndLevelSection(
                        progressBarProgress = attractionsCompleted / attractionTotal,
                        progressBarText = "$attractionsCompleted/$attractionTotal",
                        userTitle = userTitle,
                        userLevel = userLevel
                    )
                }
            }
        }
        BioSection(modifier = Modifier.weight(1.75f), bioText = bioText)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.25f)
        ) {
            MostLikedCountriesSection(
                modifier = Modifier.weight(1f),
                mostLikedCountries = mostLikedCountries
            )
            MostLikedActivitiesSection(
                modifier = Modifier.weight(1f),
                mostLikedActivities = mostLikedActivities
            )
        }
        CustomNavigationBar(
            modifier = Modifier,
            isHomeSelected = false,
            isStatisticsSelected = false,
            isProfileSelected = false,
            onHomeClicked = onHomeButtonClick,
            onStatisticsClicked = onStatisticsButtonClick,
            onProfileClicked = onProfileButtonClick
        )
    }
}

@Composable
fun ProfilePicture(
    modifier: Modifier = Modifier,
    profilePictureContentDescription: String = ""
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.android_superhero2),
            contentDescription = profilePictureContentDescription,
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    dimensionResource(R.dimen.profile_picture_border_width),
                    MaterialTheme.colorScheme.onPrimary,
                    CircleShape
                )
                .width(dimensionResource(R.dimen.user_profile_screen_image_size))
                .height(dimensionResource(R.dimen.user_profile_screen_image_size))
        )
    }
}

@Composable
fun TitleAndLevelSection(
    modifier: Modifier = Modifier,
    progressBarProgress: Float,
    progressBarText: String,
    userTitle: String,
    userLevel: Int
) {
    Column(
        modifier = modifier
            .padding(top = dimensionResource(R.dimen.user_profile_screen_title_card_padding_vertical))
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.user_profile_title, userTitle, userLevel),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.user_profile_screen_title_card_padding_vertical))
        )
        ProgressBar(modifier = Modifier, text = progressBarText, progress = progressBarProgress)
    }
}

@Composable
fun BioSection(
    modifier: Modifier = Modifier,
    bioText: String
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.user_profile_screen_card_bio_padding))
    ) {
        Text(
            text = stringResource(R.string.user_profile_screen_bio),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(dimensionResource(R.dimen.user_profile_screen_column_countries_padding)),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = bioText,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(dimensionResource(R.dimen.user_profile_screen_column_activities_padding))
        )
    }
}

@Composable
fun MostLikedCountriesSection(
    modifier: Modifier = Modifier,
    mostLikedCountries: List<String>
) {
    ElevatedCard(
        modifier = modifier
            .padding(dimensionResource(R.dimen.user_profile_screen_card_countries_padding))
            .fillMaxHeight()
    ) {
        Text(
            text = stringResource(R.string.user_profile_screen_most_liked_countries),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(dimensionResource(R.dimen.user_profile_screen_card_countries_padding)),
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier
                .padding(start = dimensionResource(R.dimen.user_profile_screen_column_countries_padding))
                .fillMaxWidth()
        ) {
            for (countryName in mostLikedCountries) {
                Text(text = countryName)
            }
        }
    }
}

@Composable
fun MostLikedActivitiesSection(
    modifier: Modifier = Modifier,
    mostLikedActivities: List<String>
) {
    ElevatedCard(
        modifier = modifier
            .padding(dimensionResource(R.dimen.user_profile_screen_card_activities_padding))
            .fillMaxHeight()
    ) {
        Text(
            text = stringResource(R.string.user_profile_screen_most_liked_attraction),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(dimensionResource(R.dimen.user_profile_screen_column_activities_padding)),
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier
                .padding(start = dimensionResource(R.dimen.user_profile_screen_column_activities_padding))
                .fillMaxWidth()
        ) {
            for (activityName in mostLikedActivities) {
                Text(text = activityName)
            }
        }
    }
}