package com.demox.presentation.base_ui.theme // ktlint-disable package-name

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = BrandColor,
    primaryVariant = BrandColor,
    onPrimary = Color.White,

    secondary = SecondaryDark,
    secondaryVariant = BrandColor,
    onSecondary = Color.White,

    background = DarkBackgroundColor,
    onBackground = Color.White,

    surface = DarkSurfaceColor,
    onSurface = Color.White,

    error = ErrorColor,
    onError = Color.White
)

private val LightColorPalette = lightColors(
    primary = BrandColor,
    primaryVariant = BrandColor,
    onPrimary = Color.White,

    secondary = Secondary,
    secondaryVariant = BrandColor,
    onSecondary = Color.White,

    background = LightGray,
    onBackground = Color.Black,

    surface = Color.White,
    onSurface = Color.Black,

    error = ErrorColor,
    onError = Color.White
)
