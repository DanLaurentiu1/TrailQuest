package com.example.trailquest.ui.screens.main_screen

import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.ModifierLocalProvider
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trailquest.R
import com.example.trailquest.ui.theme.AppTypography


@Composable
fun MainScreen() {
    val types = listOf("Restaurants", "Zoos", "Beaches", "Parks", "Lakes")
    Column(modifier = Modifier.fillMaxSize()) {
        AppBar(
            modifier = Modifier
        )
        FilterButtons(modifier = Modifier, types = types)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.padding_very_small),
                top = dimensionResource(R.dimen.padding_very_small),
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SearchBar(
            query = "",
            onQueryChange = { },
            onSearch = { },
            active = false,
            onActiveChange = { },
            placeholder = { Text("Search...") },
            modifier = Modifier
                .weight(6f)
                .padding(end = dimensionResource(R.dimen.padding_very_small))
                .height(dimensionResource(R.dimen.search_bar_height)),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_search_24),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                ProfilePictureImage(
                    drawableResource = R.drawable.android_superhero4,
                    description = "s",
                    modifier = Modifier.padding(all = dimensionResource(R.dimen.padding_very_small))
                )
            }
        ) {
        }
    }
}

@Composable
fun FilterButton(modifier: Modifier = Modifier, text: String) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(dimensionResource(R.dimen.filter_button_content_padding)),
        modifier = modifier
            .height(dimensionResource(R.dimen.filter_button_height))
            .padding(
                end = dimensionResource(
                    R.dimen.padding_medium
                )
            )
    ) {
        Text(
            text = text, style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun FilterButtons(modifier: Modifier = Modifier, types: List<String>) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.padding_very_small),
                top = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_very_small),
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(types) { item ->
            FilterButton(text = item)
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

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    MainScreen()
}