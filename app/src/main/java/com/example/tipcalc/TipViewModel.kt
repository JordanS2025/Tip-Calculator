package com.example.tipcalc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TipViewModel : ViewModel() {
    var mealCost by mutableFloatStateOf(10f)
    var numberOfFriends by mutableIntStateOf(2)
    var tipPercent by mutableFloatStateOf(10f)
    var tipValue by mutableFloatStateOf(0f)
    var totalBill by mutableFloatStateOf(0f)
    var totalPerPerson by mutableFloatStateOf(0f)

    fun calculateTipValues() {
        tipValue = tipPercent * mealCost / 100
        totalBill = tipValue + mealCost
        totalPerPerson = totalBill / numberOfFriends
    }
}
