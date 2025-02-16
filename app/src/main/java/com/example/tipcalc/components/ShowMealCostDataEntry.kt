package com.example.tipcalc.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.tipcalc.TipViewModel

@Composable
 fun ShowMealCostDataEntry(tipViewModel: TipViewModel) {
    TextField(
        value = tipViewModel.mealCost.toString(),
        label = { Text(text = "Cost of the meal") },
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.headlineMedium,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it: String ->
            val inputValue = it.toFloatOrNull()
            if (inputValue != null) {
                tipViewModel.mealCost = inputValue
                tipViewModel.calculateTipValues()
            } else {
                Log.d("ShowMealCost", "could not convert to float")
            }
        }
    )
}