package com.example.trailquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import com.example.compose.AppTheme
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                val layoutDirection = LocalLayoutDirection.current
                Surface(
                    modifier = Modifier
                        .padding(
                            start = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing.asPaddingValues()
                                .calculateEndPadding(layoutDirection)
                        )
                ) {
                    Box(modifier = Modifier) {
                        GoogleMap(
                            uiSettings = MapUiSettings(
                                compassEnabled = false,
                                mapToolbarEnabled = false,
                                myLocationButtonEnabled = false,
                                rotationGesturesEnabled = false,
                                scrollGesturesEnabled = true,
                                scrollGesturesEnabledDuringRotateOrZoom = false,
                                tiltGesturesEnabled = false,
                                zoomControlsEnabled = false,
                                zoomGesturesEnabled = true,
                            ),
                            properties = MapProperties(
                                isBuildingEnabled = false,
                                isIndoorEnabled = false,
                                isMyLocationEnabled = false,
                                isTrafficEnabled = false,
                                latLngBoundsForCameraTarget = LatLngBounds(
                                    LatLng(
                                        43.0,
                                        -16.0
                                    ),
                                    LatLng(
                                        70.0,
                                        36.0
                                    )
                                ),
                                maxZoomPreference = 7f,
                                minZoomPreference = 5.5f,
                                mapStyleOptions = MapStyleOptions(stringResource(R.string.map_style))
                            )
                        )
                        TrailQuestApplication()
                    }
                }
            }
        }
    }
}