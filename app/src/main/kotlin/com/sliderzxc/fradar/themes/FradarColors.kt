package com.sliderzxc.fradar.themes

import androidx.compose.ui.graphics.Color

val baseLightPalette = FradarColors(
    primaryBackground = Color(0xFFFFFFFF),
    primaryText = Color(0xFF3D454C),
    secondaryBackground = Color(0xFFF3F4F5),
    secondaryText = Color(0xCC7A8A99),
    tintColor = Color.Magenta,
    controlColor = Color(0xFF7A8A99),
    errorColor = Color(0xFFFF3377),
)

val baseDarkPalette = FradarColors(
    primaryBackground = Color(0xFF000000),
    primaryText = Color(0xFFF2F4F5),
    secondaryBackground = Color(0xFF191E23),
    secondaryText = Color(0xCC7A8A99),
    tintColor = Color.Magenta,
    controlColor = Color(0xFF7A8A99),
    errorColor = Color(0xFFFF6699)
)

data class FradarColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color
)