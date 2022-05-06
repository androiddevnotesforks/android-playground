package com.github.tatsuyafujisaki.androidplayground.compose

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SliderExample(
    maxValue: Float,
    onValueChange: (Float) -> Unit,
    onValueChangeStarted: () -> Unit,
    onValueChangeFinished: () -> Unit
) {
    var sliderValue by remember { mutableStateOf(0f) }
    var started by remember { mutableStateOf(true) }

    Column {
        Text(text = sliderValue.toString())
        Slider(
            value = sliderValue,
            valueRange = 0f..maxValue,
            onValueChange = {
                if (started) {
                    started = false
                    onValueChangeStarted()
                }
                onValueChange(it)
                sliderValue = it
            },
            onValueChangeFinished = {
                started = true
                onValueChangeFinished()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSliderExample() {
    SliderExample(
        maxValue = 3f,
        onValueChange = {
            Log.d("SliderExample", "onValueChange() is called. $it")
        },
        onValueChangeStarted = {
            Log.d("SliderExample", "onValueChangeStarted() is called.")
        },
        onValueChangeFinished = {
            Log.d("SliderExample", "onValueChangeFinished() is called.")
        }
    )
}