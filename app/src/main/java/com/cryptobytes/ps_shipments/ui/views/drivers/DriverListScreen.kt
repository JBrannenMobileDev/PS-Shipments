package com.cryptobytes.ps_shipments.ui.views.drivers

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.cryptobytes.ps_shipments.data.model.Assignment

@Composable
fun DriverListScreen(
    navController: NavController,
    assignments: List<Assignment>,
    onItemClicked: (item: Assignment) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        itemsIndexed(assignments){_, item ->
            DriverListItem(navController = navController, assignment = item, onItemClicked)
        }
    }
}
