package com.example.trailquest.ui.screens.statistics_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.AppTheme
import com.example.trailquest.R
import com.example.trailquest.data.DataSources
import com.example.trailquest.data.entities.Type
import com.example.trailquest.ui.reusable_components.GoBackTopAppBar
import com.example.trailquest.ui.reusable_components.ProgressBar


@Preview(showBackground = true)
@Composable
fun StatisticsScreenPreview() {
    AppTheme {
        StatisticsScreen(onBackClicked = { }, onHomeClicked = {})
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun StatisticsScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    onHomeClicked: () -> Unit,
    viewModel: StatisticsScreenViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value
    Scaffold(topBar = {
        GoBackTopAppBar(goBackOnClick = onBackClicked, goHomeOnClick = onHomeClicked)
    }, content = { paddingValues ->
        LazyColumn(
            modifier = modifier
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(paddingValues = paddingValues)
        ) {
            item {
                uiState.statistics[stringResource(R.string.statistics_screen_overall)]?.let {
                    CountrySpecificStatistics(
                        country = stringResource(R.string.statistics_screen_overall),
                        statistics = it
                    )
                }
            }
            items(uiState.allCountries) { country ->
                uiState.statistics[country.name]?.let {
                    CountrySpecificStatistics(
                        modifier = Modifier,
                        country = country.name,
                        statistics = it
                    )
                }
            }
        }
    })
}

@Composable
fun CountrySpecificStatistics(
    modifier: Modifier = Modifier, country: String = "",
    attractionTypeIconContentDescription: String = "",
    statistics: HashMap<Type, Array<Float>>
) {
    Column(modifier = modifier) {
        Text(
            text = country,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                horizontal = dimensionResource(R.dimen.statistics_screen_country_name_padding_horizontal),
                vertical = dimensionResource(R.dimen.statistics_screen_country_name_padding_vertical)
            )
        )
        LazyColumn(modifier = Modifier.height(dimensionResource(R.dimen.country_specific_statistics_height))) {
            items(statistics.entries.toList()) { entry ->
                val progress = entry.value[0] / entry.value[1]
                val text = "${entry.value[0]}/${entry.value[1]}"
                Row(
                    modifier = modifier.padding(bottom = dimensionResource(R.dimen.padding_small)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(DataSources.typesIcons[entry.key.name]!!),
                        contentDescription = attractionTypeIconContentDescription,
                        modifier = Modifier.weight(0.30f)
                    )
                    Text(
                        text = entry.key.name,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    ProgressBar(
                        modifier = Modifier.weight(1.5f),
                        text = text,
                        progress = progress
                    )
                }
            }
        }
    }
}