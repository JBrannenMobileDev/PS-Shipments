package com.cryptobytes.ps_shipments.ui.views.drivers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cryptobytes.ps_shipments.data.model.Assignment
import com.cryptobytes.ps_shipments.ui.navigation.NavigationDestination

@Composable
fun DriverListItem (
    navController: NavController,
    assignment: Assignment,
    onItemClicked: (item: Assignment) -> Unit
) {
    Card(
        modifier = Modifier
        .padding(8.dp)
        .height(64.dp)
        .fillMaxWidth()
        .clickable {
            onItemClicked(assignment)
            navController.navigate(NavigationDestination.DriverDetailsScreen.destination)
        }
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = assignment.driverName)
        }
    }
}