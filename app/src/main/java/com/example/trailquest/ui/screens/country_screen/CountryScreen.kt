package com.example.trailquest.ui.screens.country_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.AppTheme
import com.example.trailquest.R
import com.example.trailquest.data.entities.Attraction
import com.example.trailquest.ui.reusable_components.DialogBox
import com.example.trailquest.ui.reusable_components.GoBackTopAppBar
import com.example.trailquest.ui.reusable_components.RatingStar

@Preview
@Composable
private fun CountryScreenPreview() {
    AppTheme {
        CountryScreen(
            onBackClicked = { },
            onHomeClicked = { },
            onAttractionClicked = {}
        )
    }
}

@Composable
fun CountryScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    onHomeClicked: () -> Unit,
    onAttractionClicked: (String) -> Unit,
    viewModel: CountryScreenViewModel = viewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value
    Scaffold(
        topBar = {
            GoBackTopAppBar(
                goBackOnClick = onBackClicked,
                goHomeOnClick = onHomeClicked
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = modifier
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .padding(paddingValues = paddingValues)
            ) {
                item { }
                item {
                    CountryInformationSection(
                        countryName = uiState.countryName,
                        visitors = uiState.countryVisitors,
                        stars = uiState.countryStars
                    )
                }
                items(uiState.countryAttractions.entries.toList()) { entry ->
                    AttractionTypeSection(
                        modifier = Modifier,
                        attractionTypeName = entry.key.name,
                        onAttractionClicked = onAttractionClicked,
                        attractions = entry.value,
                        onCreateAttraction = { attractionName, attractionDescription ->
                            viewModel.createAttraction(
                                attractionName = attractionName,
                                attractionAboutText = attractionDescription,
                                countryName = viewModel.uiState.value.countryName,
                                typeId = entry.key.id
                            )
                        },
                        onDeleteAttraction = { attractionName ->
                            viewModel.deleteAttraction(attractionName)
                        }
                    )
                }
            }

        }
    )
}

@Composable
fun CountryInformationSection(
    modifier: Modifier = Modifier,
    countryName: String,
    visitors: Int,
    stars: Float
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.attraction_screen_country_information_card_padding))
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.attraction_screen_country_information_column_padding)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = countryName,
                    modifier = Modifier.padding(end = dimensionResource(R.dimen.country_screen_country_name_padding_end))
                )
                RatingStar(rating = stars)
            }
            Text(text = stringResource(R.string.country_screen_visitors, visitors))
        }
    }
}

@Composable
fun AttractionTypeSection(
    modifier: Modifier = Modifier, attractionTypeName: String,
    onAttractionClicked: (String) -> Unit,
    attractions: List<Attraction>,
    onCreateAttraction: (String, String) -> Unit,
    onDeleteAttraction: (String) -> Unit
) {
    var isDialogOpen by remember {
        mutableStateOf(false)
    }

    if (isDialogOpen) {
        DialogBox(onAddAttraction = onCreateAttraction,
            onDismiss = { isDialogOpen = false })
    } else {
        ElevatedCard(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    vertical = dimensionResource(R.dimen.attraction_screen_attraction_type_card_padding_vertical),
                    horizontal = dimensionResource(R.dimen.attraction_screen_attraction_type_card_padding_horizontal)
                )
        ) {
            Column(modifier = Modifier) {
                Row {
                    Text(
                        text = attractionTypeName,
                        modifier = Modifier.padding(
                            bottom = dimensionResource(R.dimen.attraction_screen_attraction_type_name_padding_bottom),
                            top = dimensionResource(R.dimen.attraction_screen_attraction_type_name_padding_top),
                            start = dimensionResource(R.dimen.attraction_screen_attraction_type_name_padding_start)
                        ),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { isDialogOpen = true }) {
                        Icon(
                            painter = painterResource(R.drawable.add_icon),
                            contentDescription = stringResource(R.string.attraction_add_icon)
                        )
                    }
                }
                for (attraction in attractions) {
                    ElevatedCard(
                        shape = RectangleShape,
                        modifier = Modifier.clickable(onClick = { onAttractionClicked(attraction.name) })
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = dimensionResource(R.dimen.attraction_screen_attraction_padding_horizontal),
                                    end = dimensionResource(R.dimen.attraction_screen_attraction_padding_horizontal),
                                    bottom = dimensionResource(R.dimen.attraction_screen_attraction_padding_bottom)
                                ),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = attraction.name, style = MaterialTheme.typography.bodyLarge
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            AttractionStatusSection(
                                modifier = Modifier,
                                isCompleted = attraction.completed
                            )
                            IconButton(onClick = { onDeleteAttraction(attraction.name) }) {
                                Icon(
                                    painter = painterResource(R.drawable.delete_icon),
                                    contentDescription = stringResource(R.string.attraction_delete_icon)
                                )
                            }
                        }
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
fun AttractionStatusSection(
    modifier: Modifier = Modifier, isCompleted: Boolean
) {
    val color =
        if (isCompleted) colorResource(R.color.completed_button_green) else colorResource(R.color.incomplete_button_red)
    val text =
        if (isCompleted) stringResource(R.string.country_screen_button_completed) else stringResource(
            R.string.country_screen_button_incomplete
        )

    OutlinedButton(
        border = BorderStroke(
            width = dimensionResource(R.dimen.country_screen_button_outline_width),
            color = MaterialTheme.colorScheme.secondary
        ),
        contentPadding = PaddingValues(dimensionResource(R.dimen.country_screen_button_text_padding)),
        modifier = modifier
            .height(dimensionResource(R.dimen.country_screen_button_height))
            .width(dimensionResource(R.dimen.country_screen_button_width))
            .padding(dimensionResource(R.dimen.country_screen_button_padding)),
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