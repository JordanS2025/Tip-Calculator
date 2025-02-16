package com.example.tipcalc.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tipcalc.TipViewModel
import java.text.NumberFormat

@Composable
fun ShowTotals(tipViewModel: TipViewModel) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp, top = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Text(
                style = MaterialTheme.typography.headlineLarge,
                text = "Each person pays:"
            )
            Text(
                text = NumberFormat.getCurrencyInstance().format(tipViewModel.totalPerPerson),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Text(
                style = MaterialTheme.typography.headlineLarge,
                text = "Total price:"
            )
            Text(
                text = NumberFormat.getCurrencyInstance().format(tipViewModel.totalBill),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

