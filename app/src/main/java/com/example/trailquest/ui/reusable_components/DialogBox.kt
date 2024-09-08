package com.example.trailquest.ui.reusable_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.compose.AppTheme
import com.example.trailquest.R

@Preview
@Composable
private fun DialogBoxPreview() {
    AppTheme {
        DialogBox(onAddAttraction = { _, _ -> }, onDismiss = {})
    }
}

@Composable
fun DialogBox(
    modifier: Modifier = Modifier,
    onAddAttraction: (String, String) -> Unit,
    onDismiss: () -> Unit
) {
    var attractionName by remember {
        mutableStateOf("")
    }

    var attractionDescription by remember {
        mutableStateOf("")
    }

    Dialog(onDismissRequest = {}) {
        Card(
            modifier = modifier
                .height(dimensionResource(R.dimen.dialog_box_card_height))
                .padding(dimensionResource(R.dimen.dialog_box_card_padding)),
            shape = RoundedCornerShape(dimensionResource(R.dimen.dialog_box_card_shape)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        vertical = dimensionResource(R.dimen.dialog_box_column_vertical_padding),
                        horizontal = dimensionResource(R.dimen.dialog_box_column_horizontal_padding)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(modifier = Modifier.padding(bottom = dimensionResource(R.dimen.dialog_box_upper_text_field_bottom_padding)),
                    value = attractionName,
                    onValueChange = { attractionName = it },
                    label = { Text(text = stringResource(R.string.attraction_name_label_text)) })
                OutlinedTextField(modifier = Modifier.padding(bottom = dimensionResource(R.dimen.dialog_box_lower_text_field_bottom_padding)),
                    value = attractionDescription,
                    onValueChange = { attractionDescription = it },
                    label = { Text(text = stringResource(R.string.attraction_description_label_text)) })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = {
                            onAddAttraction(attractionName, attractionDescription)
                        },
                        modifier = Modifier
                            .width(dimensionResource(R.dimen.dialog_box_button_width))
                            .height(dimensionResource(R.dimen.dialog_box_button_height)),
                        contentPadding = PaddingValues(dimensionResource(R.dimen.dialog_box_button_padding))
                    ) {
                        Text(text = stringResource(R.string.add_button_text))
                    }
                    Button(
                        onClick = onDismiss,
                        modifier = Modifier
                            .width(dimensionResource(R.dimen.dialog_box_button_width))
                            .height(dimensionResource(R.dimen.dialog_box_button_height)),
                        contentPadding = PaddingValues(dimensionResource(R.dimen.dialog_box_button_padding))
                    ) {
                        Text(text = stringResource(R.string.cancel_button_text))
                    }
                }
            }
        }
    }
}