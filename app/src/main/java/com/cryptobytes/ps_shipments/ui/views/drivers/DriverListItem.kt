package com.cryptobytes.ps_shipments.ui.views.drivers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
    Item(assignment = assignment, modifier = Modifier
        .padding(16.dp)
        .clickable {
            onItemClicked(assignment)
            navController.navigate(NavigationDestination.DriverDetailsScreen.destination)
        }
    )
}

@Composable
fun Item(
    assignment: Assignment, modifier: Modifier
) {
    Card(modifier = modifier) {
        Text(
            text = assignment.driverName
        )
    }
}