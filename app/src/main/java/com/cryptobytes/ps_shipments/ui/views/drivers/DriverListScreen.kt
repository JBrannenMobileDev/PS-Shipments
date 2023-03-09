package com.cryptobytes.ps_shipments.ui.views.drivers

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.cryptobytes.ps_shipments.data.model.Assignment

@Composable
fun DriverListScreen(
    navController: NavController,
    assignments: List<Assignment>,
    totalSS: Double,
    onItemClicked: (item: Assignment) -> Unit
) {
    val listState = rememberLazyListState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Drivers - Total SS = $totalSS")
                },
            )
        }, content = {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                itemsIndexed(assignments){_, item ->
                    DriverListItem(navController = navController, assignment = item, onItemClicked)
                }
            }
        })
}
