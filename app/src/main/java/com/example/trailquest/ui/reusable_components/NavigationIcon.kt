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
import com.example.compose.AppTheme
import com.example.trailquest.R

@Preview(showBackground = true)
@Composable
fun NavigationIconPreview() {
    AppTheme {
        NavigationIcon(R.drawable.statistics_icon, onClick = {})
    }
}

@Composable
fun NavigationIcon(
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.hsl(0f, 0f, 0.95f))
            .width(dimensionResource(R.dimen.navigation_bar_icon_width))
            .height(dimensionResource(R.dimen.navigation_bar_icon_height)),

        ) {
        Icon(
            painter = painterResource(icon), contentDescription = "",
            modifier = Modifier
                .height(dimensionResource(R.dimen.navigation_bar_icons_size))
                .width(dimensionResource(R.dimen.navigation_bar_icons_size))
        )
    }
}