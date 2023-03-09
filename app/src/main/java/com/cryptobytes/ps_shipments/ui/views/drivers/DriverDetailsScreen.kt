package com.cryptobytes.ps_shipments.ui.views.drivers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cryptobytes.ps_shipments.data.model.Assignment

@Composable
fun DriverDetailsScreen(
    navController: NavController,
    assignment: Assignment?,
) {
    Scaffold(
        topBar = {AppBar(navController, assignment)},
        content = {Content(it, assignment) }
    )
}

@Composable
fun Content(
    padding: PaddingValues,
    assignment: Assignment?
) {
    Column(
        Modifier.padding(32.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ScoreCard(padding, assignment)
        AddressCard(assignment)
    }
}

@Composable
fun AppBar(
    navController: NavController,
    assignment: Assignment?,
) {
    TopAppBar(
        title = {
            Text(text = assignment?.driverName ?: "Details")
        },
        navigationIcon = {
            IconButton(onClick = {navController.navigateUp()}) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
    )
}

@Composable
fun ScoreCard(
    padding: PaddingValues,
    assignment: Assignment?
) {
    Card(Modifier.padding(padding), shape = RoundedCornerShape(32.dp)) {
        Box(
            Modifier
                .width(200.dp)
                .height(150.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Suitability Score", textAlign = TextAlign.Center)
                Text(
                    text = assignment?.ss.toString(),
                    textAlign = TextAlign.Center,
                    fontSize = 48.sp
                )
            }

        }
    }
}

@Composable
fun AddressCard(
    assignment: Assignment?
) {
    Card(Modifier.padding(top = 48.dp), shape = RoundedCornerShape(32.dp)) {
        Box(Modifier.wrapContentWidth().height(64.dp).padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = assignment?.destinationAddress ?: "", textAlign = TextAlign.Center)
        }
    }
}
