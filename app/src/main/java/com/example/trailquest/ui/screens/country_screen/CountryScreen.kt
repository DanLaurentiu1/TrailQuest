package com.example.trailquest.ui.screens.country_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
            .padding(vertical = 6.dp, horizontal = 8.dp)
    ) {
        Column(modifier = Modifier) {
            Text(
                text = attractionTypeName,
                modifier = Modifier.padding(bottom = 4.dp, top = 10.dp, start = 8.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            for (attraction in DataSources.attractions) {
                Card {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 40.dp, end = 40.dp, bottom = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = attraction, style = MaterialTheme.typography.bodyLarge
                        )
                        AttractionStatusSection(modifier = Modifier, isCompleted = false)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AttractionStatusSectionPrev() {
    AttractionStatusSection(modifier = Modifier, isCompleted = true)
}

@Composable
fun AttractionStatusSection(modifier: Modifier = Modifier, isCompleted: Boolean) {
    val color =
        if (isCompleted) Color.Green else Color.Red
    val text = if (isCompleted) "Completed" else "Incomplete"

    OutlinedButton(
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.secondary),
        contentPadding = PaddingValues(1.dp),
        modifier = modifier
            .height(33.dp)
            .width(82.dp)
            .padding(4.dp),
        onClick = { },
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.labelMedium
        )
    }
}