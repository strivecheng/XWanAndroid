package com.strive.xwanandroid.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable


/**
 * @author strivexing
 * @date 2022/3/22 22:01
 * @description
 */
open class BottomNavItem(
    @StringRes val label: Int,
    val icon: @Composable () -> Unit,
    val route: String
)
