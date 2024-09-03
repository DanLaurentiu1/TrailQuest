package com.example.trailquest.ui.reusable_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.AppTheme
import com.example.trailquest.R

@Preview(showBackground = true)
@Composable
private fun ProgressBarPreview() {
    AppTheme {
        ProgressBar(modifier = Modifier, text = "0/10", progress = 0.65f)
    }
}

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    text: String,
    progress: Float
) {
    Box(
        modifier = modifier
            .clip(shape = CircleShape)
            .border(
                width = dimensionResource(R.dimen.progress_bar_border),
                color = Color.Black,
                shape = CircleShape
            )
            .height(dimensionResource(id = R.dimen.progress_bar_height))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .width(dimensionResource(R.dimen.progress_bar_width))
    ) {
        Box(
            modifier = modifier
                .clip(shape = CircleShape)
                .height(dimensionResource(id = R.dimen.progress_bar_height))
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            MaterialTheme.colorScheme.surfaceVariant,
                            MaterialTheme.colorScheme.primary
                        )
                    )
                )
                .width(dimensionResource(R.dimen.progress_bar_width) * progress)
        )
        Text(text = text, modifier = Modifier.align(Alignment.Center))
    }
}