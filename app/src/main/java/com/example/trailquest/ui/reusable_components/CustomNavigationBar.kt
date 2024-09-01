package com.example.trailquest.ui.reusable_components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trailquest.R
import com.example.trailquest.ui.theme.TrailQuestAppTheme

@Composable
fun CustomNavigationBar() {
    NavigationBar(
        modifier = Modifier
            .clip(
                RoundedCornerShape(4.dp)
            )
    ) {
        Row(
            modifier = Modifier,
        ) {
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = { NavigationIcon(R.drawable.rounded_home_24) },
                label = { Text(text = "Home") })
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = { NavigationIcon(R.drawable.statistics_icon) },
                label = { Text(text = "Statistics") })
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = { NavigationIcon(R.drawable.profile_picture_icon) },
                label = { Text(text = "Profile") })

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomNavigationBarPreview() {
    TrailQuestAppTheme {
        CustomNavigationBar()
    }
}