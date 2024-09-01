package com.example.trailquest.ui.reusable_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import com.example.trailquest.R

@Composable
fun ProgressBar(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        LinearProgressIndicator(
            progress = { 0.35f }, modifier = Modifier
                .height(
                    dimensionResource(R.dimen.progress_bar_height)
                )
                .clip(CircleShape)
        )
        Text(text = "0/10")
    }
}