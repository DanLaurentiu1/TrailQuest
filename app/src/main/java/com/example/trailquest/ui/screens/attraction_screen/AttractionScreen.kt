package com.example.trailquest.ui.screens.attraction_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.AppTheme
import com.example.trailquest.R
import com.example.trailquest.ui.reusable_components.CustomNavigationBar
import com.example.trailquest.ui.reusable_components.GoBackTopAppBar

@Preview(showBackground = true)
@Composable
private fun AttractionScreenPreview() {
    AppTheme {
        AttractionScreen(
            modifier = Modifier,
            onHomeClicked = {},
            onBackClicked = {},
            onProfileClicked = {},
            onStatisticsClicked = {},
            viewModel = viewModel()
        )
    }
}

@Composable
fun AttractionScreen(
    modifier: Modifier = Modifier,
    onHomeClicked: () -> Unit,
    onBackClicked: () -> Unit,
    onStatisticsClicked: () -> Unit,
    onProfileClicked: () -> Unit,
    viewModel: AttractionScreenViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value

    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.onPrimary)) {
        GoBackTopAppBar(goBackOnClick = onBackClicked, goHomeOnClick = onHomeClicked)
        AttractionTitleSection(
            modifier = Modifier.weight(1f),
            attractionTitle = uiState.attractionName
        )
        AttractionAboutSection(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.attraction_screen_about_me_section_padding)),
            aboutText = uiState.aboutText,
            isChecked = uiState.isCompleted,
            onChecked = { /* VIEW MODEL HERE */ }
        )
        CustomNavigationBar(
            modifier = Modifier,
            isHomeSelected = false,
            isStatisticsSelected = false,
            isProfileSelected = false,
            onHomeClicked = onHomeClicked,
            onStatisticsClicked = onStatisticsClicked,
            onProfileClicked = onProfileClicked
        )
    }
}

@Composable
fun AttractionTitleSection(
    modifier: Modifier = Modifier,
    contentDescription: String = "",
    attractionTitle: String
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.android_superhero1),
            contentDescription = contentDescription,
            contentScale = ContentScale.FillWidth
        )
        Column {
            Spacer(modifier = Modifier.weight(2f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = attractionTitle,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun AttractionAboutSection(
    modifier: Modifier = Modifier,
    aboutText: String,
    isChecked: Boolean,
    onChecked: (Boolean) -> Unit
) {
    ElevatedCard(
        onClick = { },
        modifier = modifier
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(R.dimen.attraction_screen_about_row_padding_horizontal),
                    vertical = dimensionResource(R.dimen.attraction_screen_about_row_padding_vertical)
                )
            ) {
                Text(
                    text = stringResource(R.string.attraction_screen_about),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(checked = isChecked, onCheckedChange = onChecked)
            }
            Text(
                text = aboutText,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.attraction_screen_about_me_text_padding))
            )
        }
    }
}