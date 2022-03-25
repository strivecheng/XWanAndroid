/*
 * Dr. Ing. h.c. F. Porsche AG confidential. This code is protected by intellectual property rights.
 * The Dr. Ing. h.c. F. Porsche AG owns exclusive legal rights of use.
 */
package com.strive.ui.kit.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.icons.Icons
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.Colors as MaterialColors
import androidx.compose.material.Typography as MaterialTypography

@Composable
fun StriveTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val porscheColors = remember(isDarkMode) { if (isDarkMode) darkColors else lightColors }
    val materialColors = remember(isDarkMode) { getMaterialColors(isDarkMode) }
//    val porscheSwitchColors = remember(porscheColors) { getPorscheSwitchColors(porscheColors) }

    val materialShapes = remember {
        Shapes(
            small = RoundedCornerShape(0.dp),
            medium = RoundedCornerShape(0.dp),
            large = RoundedCornerShape(0.dp),
        )
    }

    val materialTypography = remember {
        MaterialTypography(
            defaultFontFamily = StriveTheme.typography.fontFamily,
            h4 = StriveTheme.typography.headline1,
            h5 = StriveTheme.typography.headline2,
            h6 = StriveTheme.typography.headline3,
            body1 = StriveTheme.typography.textCopy,
            body2 = StriveTheme.typography.textMedium,
            button = TextStyle(fontWeight = FontWeight.Normal, fontSize = 16.sp),
            caption = StriveTheme.typography.textSmall,
        )
    }

    MaterialTheme(
        colors = materialColors,
        typography = materialTypography,
        shapes = materialShapes,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colors.onBackground,
            LocalContentAlpha provides 1f,
            LocalPorscheColors provides porscheColors,
//            LocalPorscheSwitchColors provides porscheSwitchColors,
//            LocalRippleTheme provides PorscheRippleTheme,
            content = content
        )
    }
}

private fun getMaterialColors(isDarkMode: Boolean): MaterialColors {
    with(StriveTheme.colorPalette) {
        return if (isDarkMode) {
            MaterialColors(
                primary = PorscheRed,
                primaryVariant = PorscheDarkRed,
                secondary = NeutralContrastMediumDark,
                secondaryVariant = PorscheRed,
                background = BackgroundDark,
                surface = SurfaceDark,
                error = NotificationErrorDark,
                onPrimary = ForegroundDark,
                onSecondary = Color.Black,
                onBackground = Color.White,
                onSurface = ForegroundDark,
                onError = Color.Black,
                isLight = false,
            )
        } else {
            MaterialColors(
                primary = PorscheRed,
                primaryVariant = PorscheDarkRed,
                secondary = NeutralContrastMediumLight,
                secondaryVariant = PorscheRed,
                background = BackgroundLight,
                surface = SurfaceLight,
                error = NotificationErrorLight,
                onPrimary = ForegroundDark,
                onSecondary = Color.Black,
                onBackground = Color.Black,
                onSurface = ForegroundLight,
                onError = Color.White,
                isLight = false,
            )
        }
    }
}

object StriveTheme {
    val typography = Typography
    val icons = Icons
    val transitions = Transitions
    val colorPalette = ColorPalette
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalPorscheColors.current
}
