package com.strive.xwanandroid.ui.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.strive.xwanandroid.ui.theme.StriveTheme

/**
 * @author strivexing
 * @date 2022/3/25 21:56
 * @description
 */

@Composable
fun StriveTag(
    modifier: Modifier = Modifier,
    title: String,
    color: Color = StriveTheme.colors.striveRed,
    style: TextStyle = StriveTheme.typography.textSmall
) {
    Text(
        text = title,
        color = color,
        style = style,
        modifier = modifier
            .border(
                1.dp,
                color,
                shape = RoundedCornerShape(2.dp)
            )
            .padding(start = 4.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
    )
}