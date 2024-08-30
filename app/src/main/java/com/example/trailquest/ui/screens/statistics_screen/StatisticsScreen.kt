package com.example.trailquest.ui.screens.statistics_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
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
import com.example.trailquest.data.datasource.DataSources
import com.example.trailquest.ui.theme.TrailQuestAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatisticsScreen(modifier: Modifier = Modifier) {
    OverallStatistics()
}

@Composable
fun StatisticsTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(
                    start = dimensionResource(R.dimen.padding_small),
                    top = dimensionResource(R.dimen.padding_small),
                    bottom = dimensionResource(R.dimen.padding_small)
                )
                .background(MaterialTheme.colorScheme.primary, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Statistics", modifier = Modifier.weight(4f))
    }
}


@Composable
fun OverallStatistics(modifier: Modifier = Modifier) {
    LazyColumn {
        item { StatisticsTopAppBar(modifier = modifier) }
        item {
            CountrySpecificStatistics(country = "Overall Statistics")
        }
        items(DataSources.countries) { country ->
            CountrySpecificStatistics(modifier = Modifier, country = country)
        }
    }
}

@Composable
fun CountrySpecificStatistics(modifier: Modifier = Modifier, country: String = "") {
    Column(modifier = modifier) {
        Text(text = country, style = MaterialTheme.typography.displayMedium)
        LazyColumn(modifier = Modifier.height(dimensionResource(R.dimen.country_specific_statistics_height))) {
            items(DataSources.types) { item ->
                Row(
                    modifier = modifier.padding(bottom = dimensionResource(R.dimen.padding_small)),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(DataSources.typesIcons[item]!!),
                        contentDescription = "",
                        modifier = Modifier.weight(0.30f)
                    )
                    Text(
                        text = item,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Box(modifier = Modifier.weight(1.5f), contentAlignment = Alignment.Center) {
                        LinearProgressIndicator(
                            progress = { 0.35f }, modifier = Modifier
                                .height(
                                    dimensionResource(R.dimen.progress_bar_height)
                                )
                                .clip(CircleShape)
                        )
                        Text(text = "0/10")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StatisticsScreenPreview() {
    TrailQuestAppTheme {
        StatisticsScreen()
    }
}
