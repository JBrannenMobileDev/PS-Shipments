package com.cryptobytes.ps_shipments.ui.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

class MainHeader {
    @Composable
    fun MainHeader(){
        Surface(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
        ) {
            Text(
                text = "Trending Movies",
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center
            )
        }
    }
}