package com.example.trailquest.ui.reusable_components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trailquest.R
import com.example.trailquest.ui.theme.TrailQuestAppTheme

@Preview
@Composable
fun NavigationIconPreview() {
    TrailQuestAppTheme {
        NavigationIcon(R.drawable.statistics_icon)
    }
}

@Composable
fun NavigationIcon(@DrawableRes icon: Int) {
    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.hsl(245f, 0.64f, 0.92f))
            .width(80.dp)
            .height(32.dp),

        ) {
        Icon(
            painter = painterResource(icon), contentDescription = "",
            modifier = Modifier
                .height(dimensionResource(R.dimen.navigation_bar_icons_size))
                .width(dimensionResource(R.dimen.navigation_bar_icons_size))
        )
    }
}