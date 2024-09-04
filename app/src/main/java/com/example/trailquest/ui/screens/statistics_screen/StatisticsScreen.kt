package com.example.trailquest.ui.screens.statistics_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.trailquest.R
import com.example.trailquest.data.datasource.DataSources
import com.example.trailquest.ui.reusable_components.GoBackTopAppBar
import com.example.trailquest.ui.reusable_components.ProgressBar

@Composable
fun StatisticsScreen() {
    OverallStatistics()
}

@Composable
fun OverallStatistics() {
    LazyColumn {
        item {
            GoBackTopAppBar(goBackOnClick = { /*TODO*/ }, goHomeOnClick = {})
        }
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
        Text(
            text = country, style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold, modifier = Modifier.padding(4.dp)
        )
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
                    ProgressBar(modifier = Modifier.weight(1.5f), text = "0/10", progress = 0.75f)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StatisticsScreenPreview() {
    AppTheme {
        StatisticsScreen()
    }
}
