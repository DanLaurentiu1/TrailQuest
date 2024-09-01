package com.example.trailquest.ui.screens.attraction_screen

import android.widget.Checkable
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trailquest.R
import com.example.trailquest.ui.reusable_components.CustomNavigationBar
import com.example.trailquest.ui.reusable_components.GoBackTopAppBar
import com.example.trailquest.ui.theme.TrailQuestAppTheme

@Preview(showBackground = true)
@Composable
private fun AttractionScreenPreview() {
    TrailQuestAppTheme {
        AttractionScreen()
    }
}

@Composable
fun AttractionScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        GoBackTopAppBar()
        AttractionTitleSection(modifier = Modifier.weight(1f))
        AttractionAboutSection(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(12.dp)
        )
        CustomNavigationBar()
    }
}

@Composable
fun AttractionTitleSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.android_superhero1),
            contentDescription = "",
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
                    text = "Attraction 1",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun AttractionAboutSection(modifier: Modifier = Modifier) {
    Card(
        onClick = { /*TODO*/ },
        modifier = modifier
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp, top = 4.dp)
            ) {
                Text(
                    text = "About",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(checked = false, onCheckedChange = {})
            }
            Text(
                text = "asdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasddasdasdd",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(14.dp)
            )
        }
    }
}