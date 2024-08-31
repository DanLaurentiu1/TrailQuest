package com.example.trailquest.ui.screens.profile_screen

import android.view.Display.Mode
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
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
import com.example.trailquest.ui.reusable_components.CustomNavigationBar
import com.example.trailquest.ui.reusable_components.GoBackTopAppBar
import com.example.trailquest.ui.theme.TrailQuestAppTheme

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    TrailQuestAppTheme {
        UserProfileScreen()
    }
}

@Composable
fun UserProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        GoBackTopAppBar()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            ProfilePicture()
            Column {
                Text(text = "HogRida", style = MaterialTheme.typography.displaySmall)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        CustomNavigationBar()
    }
}

@Composable
fun ProfilePicture() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.android_superhero2), contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    dimensionResource(R.dimen.profile_picture_border_width),
                    MaterialTheme.colorScheme.secondary,
                    CircleShape
                )
                .width(140.dp)
                .height(140.dp)
        )
    }
}

@Composable
fun LevelBar() {

}

@Composable
fun AboutMeSection() {

}