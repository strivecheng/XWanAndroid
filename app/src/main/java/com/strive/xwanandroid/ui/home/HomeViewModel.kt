package com.strive.xwanandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strive.xwanandroid.service.HomeService
import com.strive.xwanandroid.ui.home.data.HomeAllDataInfo
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

/**
 * @author strivexing
 * @date 2022/3/23 18:54
 * @description
 */
class HomeViewModel(private val homeService: HomeService) : ViewModel() {

    init {
        fetchHomeAllData()
    }

    internal val viewState = combine(
        homeService.homeBannerFlow,
        homeService.homeTopArticleListFlow,
        homeService.homeHotArticleListFlow,
    ) { homeBanner, homeTopArticle, homeHotArticle ->
        HomePageViewState.ShowHomeAndData(
            homeAllDataInfo = HomeAllDataInfo(
                homeBanner,
                homeTopArticle,
                homeHotArticle.datas
            )
        )
    }

    fun fetchHomeAllData() {
        viewModelScope.launch {
            homeService.fetchHomeTopArticle()
            homeService.fetchHomeHotArticle(0)
            homeService.fetchHomeBanner()
        }
    }
}