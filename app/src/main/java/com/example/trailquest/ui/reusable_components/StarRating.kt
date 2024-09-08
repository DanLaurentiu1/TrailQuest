package com.example.trailquest.ui.reusable_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.example.compose.AppTheme
import com.example.trailquest.R

@Preview(showBackground = true)
@Composable
private fun RatingStarPrev() {
    AppTheme {
        RatingStar(
            rating = 4.35f
        )
    }
}

@Composable
fun RatingStar(
    rating: Float = 5f,
    maxNumberOfStars: Int = 5,
) {
    Row {
        for (i in 1..maxNumberOfStars) {
            if (i <= rating.toInt()) {
                Icon(
                    imageVector = Icons.Rounded.Star,
                    contentDescription = stringResource(R.string.fully_filled_star),
                    tint = colorResource(R.color.star_fill_yellow),
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.rating_bar_icon_size))
                )
            } else if (i == rating.toInt() + 1 && rating % 1 != 0f) {
                PartialStar(fraction = rating % 1)
            } else {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = stringResource(R.string.empty_star),
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.rating_bar_icon_size))
                )
            }
        }
    }
}

@Composable
private fun PartialStar(fraction: Float) {
    val customShape = FractionalClipShape(fraction)

    Box {
        Icon(
            imageVector = Icons.Rounded.Star,
            contentDescription = stringResource(R.string.partially_filled_star),
            tint = Color.Gray,
            modifier = Modifier.size(dimensionResource(R.dimen.rating_bar_icon_size))
        )
        Box(
            modifier = Modifier
                .graphicsLayer(
                    clip = true,
                    shape = customShape
                )
        ) {
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = stringResource(R.string.partially_filled_star),
                tint = colorResource(R.color.star_fill_yellow),
                modifier = Modifier.size(dimensionResource(R.dimen.rating_bar_icon_size))
            )
        }
    }
}

private class FractionalClipShape(private val fraction: Float) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Rectangle(
            rect = Rect(
                left = 0f,
                top = 0f,
                right = size.width * fraction,
                bottom = size.height
            )
        )
    }
}