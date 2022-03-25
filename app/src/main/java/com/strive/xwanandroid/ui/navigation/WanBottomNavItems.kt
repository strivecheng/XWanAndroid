package com.strive.xwanandroid.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import com.strive.xwanandroid.R
import com.strive.xwanandroid.common.WanAndroidRoutes

/**
 * @author strivexing
 * @date 2022/3/22 23:31
 * @description
 */
sealed class WanBottomNavItems(
    @StringRes val label: Int,
    val icon: @Composable () -> Unit,
    val route: String
) {
    object HomeItem : WanBottomNavItems(R.string.home, icon = {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = null
        )
    }, WanAndroidRoutes.HOME_PAGE)

    object SquareItem : WanBottomNavItems(R.string.square, icon = {
        Icon(
            imageVector = Icons.Filled.Place,
            contentDescription = null
        )
    }, WanAndroidRoutes.SQUARE_PAGE)

    object DiscoverItem : WanBottomNavItems(R.string.discover, icon = {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null
        )
    }, WanAndroidRoutes.DISCOVER_PAGE)

    object MyItem : WanBottomNavItems(R.string.my, icon = {
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = null
        )
    }, WanAndroidRoutes.MY_PAGE)

}