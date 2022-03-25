package com.strive.xwanandroid.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class Colors internal constructor(
    val striveRed: Color,
    val background: Color,
    val surface: Color,
    val foreground: Color,
    val neutralContrastHigh: Color,
    val neutralContrastMedium: Color,
    val neutralContrastLow: Color,
    val backgroundErrorSoft: Color,
    val backgroundNeutralSoft: Color,
    val backgroundSuccessSoft: Color,
    val backgroundWarningSoft: Color,
    val notificationError: Color,
    val notificationNeutral: Color,
    val notificationSuccess: Color,
    val notificationWarning: Color,
    val stateDisabled: Color,
    val stateActive: Color,
    val statePressed: Color,
    val controlNormal: Color,
    val independentDark: Color,
    val independentLight: Color,
    val acidGreen: Color,
    val phantomBlue: Color,
    val fadingEdge: Color
)

/**
 * The colors for the light mode. Do not define color values here.
 * The actual hex values belong into the [ColorPalette].
 */
internal val lightColors: Colors = with(ColorPalette) {
    Colors(
        striveRed = PorscheRed,
        background = BackgroundLight,
        surface = SurfaceLight,
        foreground = ForegroundLight,
        neutralContrastHigh = NeutralContrastHighLight,
        neutralContrastMedium = NeutralContrastMediumLight,
        neutralContrastLow = NeutralContrastLowLight,
        backgroundErrorSoft = BackgroundErrorSoftLight,
        backgroundNeutralSoft = BackgroundNeutralSoftLight,
        backgroundSuccessSoft = BackgroundSuccessSoftLight,
        backgroundWarningSoft = BackgroundWarningSoftLight,
        notificationError = NotificationErrorLight,
        notificationNeutral = NotificationNeutralLight,
        notificationSuccess = NotificationSuccessLight,
        notificationWarning = NotificationWarningLight,
        stateDisabled = StateDisabledLight,
        stateActive = StateActiveLight,
        statePressed = StatePressedLight,
        controlNormal = IndependentLight,
        independentDark = IndependentDark,
        independentLight = IndependentLight,
        acidGreen = AcidGreen,
        phantomBlue = PhantomBlueLight,
        fadingEdge = FadingEdgeLight
    )
}

/**
 * The colors for the dark mode. Do not define color values here.
 * The actual hex values belong into the [ColorPalette].
 */
internal val darkColors = with(ColorPalette) {
    Colors(
        striveRed = PorscheRed,
        background = BackgroundDark,
        surface = SurfaceDark,
        foreground = ForegroundDark,
        neutralContrastHigh = NeutralContrastHighDark,
        neutralContrastMedium = NeutralContrastMediumDark,
        neutralContrastLow = NeutralContrastLowDark,
        backgroundErrorSoft = BackgroundErrorSoftDark,
        backgroundNeutralSoft = BackgroundNeutralSoftDark,
        backgroundSuccessSoft = BackgroundSuccessSoftDark,
        backgroundWarningSoft = BackgroundWarningSoftDark,
        notificationError = NotificationErrorDark,
        notificationNeutral = NotificationNeutralDark,
        notificationSuccess = NotificationSuccessDark,
        notificationWarning = NotificationWarningDark,
        stateDisabled = StateDisabledDark,
        stateActive = StateActiveDark,
        statePressed = StatePressedDark,
        controlNormal = IndependentDark,
        independentDark = IndependentDark,
        independentLight = IndependentLight,
        acidGreen = AcidGreen,
        phantomBlue = PhantomBlueDark,
        fadingEdge = FadingEdgeDark
    )
}

internal val LocalPorscheColors = staticCompositionLocalOf { lightColors }
