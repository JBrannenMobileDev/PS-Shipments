package com.cryptobytes.ps_shipments.ui.navigation

sealed class NavigationDestination(open val destination: String) {
    object DriversScreen : NavigationDestination("drivers_screen")
    object DriverDetailsScreen : NavigationDestination("driver_details_screen")
}