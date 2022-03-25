package com.strive.xwanandroid.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.strive.xwanandroid.R

object Typography {

    val fontFamily: FontFamily = FontFamily(
        Font(R.font.strive_next_thin, FontWeight.ExtraLight),
        Font(R.font.strive_next_regular, FontWeight.Normal),
        Font(R.font.strive_next_semi_bold, FontWeight.SemiBold),
        Font(R.font.strive_next_bold, FontWeight.ExtraBold),
    )

    private val baseStyle: TextStyle
        get() = TextStyle(fontWeight = FontWeight.Normal, fontFamily = fontFamily)

    val headline1: TextStyle
        get() = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 28.sp,
            fontFamily = fontFamily
        )

    val headline2: TextStyle
        get() = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            fontFamily = fontFamily
        )

    val headline3: TextStyle
        get() = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            fontFamily = fontFamily
        )

    val textCopy: TextStyle
        get() = baseStyle.copy(fontSize = 16.sp)

    val textMedium: TextStyle
        get() = baseStyle.copy(fontSize = 14.sp)

    val textSmall: TextStyle
        get() = baseStyle.copy(fontSize = 12.sp)

    val button1: TextStyle
        get() = baseStyle.copy(fontSize = 16.sp)

    val button2: TextStyle
        get() = baseStyle.copy(fontSize = 14.sp)

    val TextStyle.neutral: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = copy(color = StriveTheme.colors.neutralContrastMedium)

    val TextStyle.active: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = copy(
            color = StriveTheme.colors.stateActive,
            textDecoration = TextDecoration.Underline,
        )

    val TextStyle.disabled: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = copy(color = StriveTheme.colors.stateDisabled)

    val TextStyle.highlight: TextStyle
        get() = copy(fontWeight = FontWeight.SemiBold)

    val TextStyle.error: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = copy(color = StriveTheme.colors.notificationError)

    val TextStyle.success: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = copy(color = StriveTheme.colors.notificationSuccess)

    val TextStyle.warning: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = copy(color = StriveTheme.colors.notificationWarning)
}
