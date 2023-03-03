package com.cryptobytes.ps_shipments.ui.views.drivers_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

class DriverListScreen {

    @Composable
    fun DriverListScreen(
        navController: NavController,
        sharedViewModel: DriversViewModel = viewModel()
    ) {
        var listState = rememberLazyListState()

        LazyColumn(state = listState) {
            itemsIndexed(movieList){index, item ->
                ListViewItem( movieItem = item)
            }
        }
    }
}