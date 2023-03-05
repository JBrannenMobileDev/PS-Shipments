package com.cryptobytes.ps_shipments.ui.views.drivers

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.cryptobytes.ps_shipments.data.model.Assignment

@Composable
fun DriverDetailsScreen(
    assignment: Assignment?,
) {
    Column {
        Text(text = assignment?.driverName ?: "")
        Text(text = assignment?.ss.toString())
        Text(text = assignment?.destinationAddress ?: "")
    }
}
