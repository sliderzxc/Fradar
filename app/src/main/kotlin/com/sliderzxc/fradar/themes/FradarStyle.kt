package com.sliderzxc.fradar.themes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object FradarStyle {
    val colors: FradarColors
        @Composable
        get() = LocalFradarColors.current
}

val LocalFradarColors = staticCompositionLocalOf<FradarColors> {
    error("No colors provided")
}