package com.cryptobytes.ps_shipments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cryptobytes.ps_shipments.ui.navigation.NavigationDestination
import com.cryptobytes.ps_shipments.ui.theme.PSShipmentsTheme
import com.cryptobytes.ps_shipments.ui.uiState.collectWithLifecycle
import com.cryptobytes.ps_shipments.ui.views.drivers.DriverDetailsScreen
import com.cryptobytes.ps_shipments.ui.views.drivers.DriverListScreen
import com.cryptobytes.ps_shipments.ui.views.drivers.DriversViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val driversViewModel = hiltViewModel<DriversViewModel>()

            PSShipmentsTheme {
                NavHost(navController = navController, startDestination = NavigationDestination.DriversScreen.destination) {

                    composable(NavigationDestination.DriversScreen.destination) {
                        val uiState by driversViewModel.collectWithLifecycle()
                        DriverListScreen(navController = navController, assignments = uiState.assignments, driversViewModel::itemClicked)
                    }

                    composable(NavigationDestination.DriverDetailsScreen.destination) {
                        val uiState by driversViewModel.collectWithLifecycle()
                        DriverDetailsScreen(uiState.selectedAssignment)
                    }
                }
            }
        }
    }
}