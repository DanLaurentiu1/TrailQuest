package com.example.trailquest.ui.screens.main_screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.AppTheme
import com.example.trailquest.R
import com.example.trailquest.data.datasource.DataSources
import com.example.trailquest.ui.reusable_components.CustomNavigationBar

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    MainScreen()
}

@Composable
fun MainScreen() {
    AppTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            SearchAppBar(
                modifier = Modifier,
                onSearchClick = {},
                onQueryChange = {},
                isSearchBarActive = false,
                onActiveChange = {}
            )
            FilterButtons(modifier = Modifier)
            Spacer(modifier = Modifier.weight(1f))
            CustomNavigationBar(
                modifier = Modifier,
                isHomeSelected = false,
                isStatisticsSelected = false,
                isProfileSelected = false,
                onHomeClicked = { },
                onStatisticsClicked = { },
                onProfileClicked = { })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    modifier: Modifier = Modifier,
    searchIconContentDescription: String = "",
    profilePictureContentDescription: String = "",
    searchBarQuery: String = "",
    onSearchClick: (String) -> Unit,
    onQueryChange: (String) -> Unit,
    isSearchBarActive: Boolean,
    onActiveChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.padding_small),
                top = dimensionResource(R.dimen.padding_medium),
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchBar(
            query = searchBarQuery,
            onQueryChange = onQueryChange,
            onSearch = onSearchClick,
            active = isSearchBarActive,
            onActiveChange = onActiveChange,
            placeholder = { Text(stringResource(R.string.search_bar_placeholder)) },
            modifier = Modifier
                .weight(6f)
                .padding(end = dimensionResource(R.dimen.padding_very_small))
                .height(dimensionResource(R.dimen.search_bar_height)),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.rounded_search_24),
                    contentDescription = searchIconContentDescription
                )
            },
            trailingIcon = {
                ProfilePictureImage(
                    drawableResource = R.drawable.android_superhero4,
                    description = profilePictureContentDescription,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_very_small))
                )
            }
        ) {
        }
    }
}

@Composable
fun FilterButton(
    modifier: Modifier = Modifier, text: String,
    onFilterButtonClick: () -> Unit
) {
    OutlinedButton(
        onClick = onFilterButtonClick,
        contentPadding = PaddingValues(dimensionResource(R.dimen.filter_button_content_padding)),
        modifier = modifier
            .height(dimensionResource(R.dimen.filter_button_height))
            .padding(
                end = dimensionResource(
                    R.dimen.padding_medium
                )
            ),
        border = BorderStroke(
            width = dimensionResource(R.dimen.filter_button_border_width),
            color = MaterialTheme.colorScheme.secondary
        ),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Text(
            text = text, style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun FilterButtons(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.padding_very_small),
                top = dimensionResource(R.dimen.padding_very_high),
                end = dimensionResource(R.dimen.padding_very_small),
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(DataSources.types) { item ->
            FilterButton(text = item, onFilterButtonClick = {})
        }
    }
}

@Composable
fun ProfilePictureImage(
    @DrawableRes drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier.clip(CircleShape),
            painter = painterResource(drawableResource),
            contentDescription = description,
        )
    }
}