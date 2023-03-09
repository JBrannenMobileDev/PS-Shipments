package com.cryptobytes.ps_shipments.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    surface = Black_Secondary,
    primary = Primary_Dark,
    primaryVariant = Primary_Dark_Variant,
    secondary = orange,
    background = Black,
)

private val LightColorPalette = lightColors(
    surface = White,
    primary = Primary_Light,
    primaryVariant = Primary_Light_Variant,
    secondary = orange,
    background = Grey_Light,
)

@Composable
fun PSShipmentsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}