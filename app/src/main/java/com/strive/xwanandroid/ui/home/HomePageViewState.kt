package com.strive.xwanandroid.ui.home

import com.strive.xwanandroid.ui.home.data.HomeAllDataInfo

/**
 * @author strivexing
 * @date 2022/3/24 19:29
 * @description
 */

internal sealed class HomePageViewState {
    object Default : HomePageViewState()
    data class ShowHomeAndData(val homeAllDataInfo: HomeAllDataInfo) : HomePageViewState()
}