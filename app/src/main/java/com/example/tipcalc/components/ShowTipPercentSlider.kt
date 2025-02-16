package com.example.tipcalc.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tipcalc.TipViewModel
import java.text.NumberFormat

@Composable
 fun ShowTipPercentSlider(tipViewModel: TipViewModel) {
    var sliderState = remember { mutableStateOf(tipViewModel.tipPercent) }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            val str = String.format(
                "Tip Percent: %.1f%% Tip Value: " +
                        NumberFormat.getCurrencyInstance().format(tipViewModel.tipValue),
                tipViewModel.tipPercent
            )

            Text(str)

            Slider(
                value = sliderState.value,
                valueRange = 0f..100f,
                onValueChange = { newValue ->
                    sliderState.value = newValue
                    tipViewModel.tipPercent = newValue
                    tipViewModel.calculateTipValues()
                }
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf(10f, 15f, 20f, 25f).forEach { percent ->
                    Button(
                        onClick = {
                            sliderState.value = percent
                            tipViewModel.tipPercent = percent
                            tipViewModel.calculateTipValues()
                        }
                    ) {
                        Text(text = "${percent.toInt()}%")
                    }
                }
            }
        }
    }
}
