package com.example.trailquest.ui.screens.country_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.trailquest.R
import com.example.trailquest.data.datasource.DataSources
import com.example.trailquest.ui.reusable_components.GoBackTopAppBar

@Preview(showBackground = true)
@Composable
private fun CountryScreenPreview() {
    AppTheme {
        CountryScreen()
    }
}

@Composable
fun CountryScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        item { GoBackTopAppBar(goBackOnClick = { /*TODO*/ }, goHomeOnClick = {}) }
        item { CountryInformationSection() }
        items(DataSources.types) { type ->
            AttractionTypeSection(modifier = Modifier, type)
        }
    }
}

@Composable
fun CountryInformationSection(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "France", modifier = Modifier.padding(end = 16.dp))
                for (i in 1..5) {
                    Icon(painter = painterResource(R.drawable.star_icon), contentDescription = "")
                }
            }
            Text(text = "12658 visitors last month")
        }
    }
}

@Composable
fun AttractionTypeSection(modifier: Modifier = Modifier, attractionTypeName: String) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier) {
            Text(
                text = attractionTypeName,
                modifier = Modifier.padding(bottom = 4.dp, top = 10.dp, start = 8.dp)
            )
            for (attraction in DataSources.attractions) {
                Card {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp, end = 8.dp, bottom = 2.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = attraction)
                        Row {
                            for (i in 1..5) {
                                Icon(
                                    painter = painterResource(R.drawable.star_icon),
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}