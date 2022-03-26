package com.strive.xwanandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strive.xwanandroid.service.HomeService
import com.strive.xwanandroid.ui.home.data.HomeAllDataInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

/**
 * @author strivexing
 * @date 2022/3/23 18:54
 * @description
 */
class HomeViewModel(private val homeService: HomeService) : ViewModel() {
    private val _isRefreshing = MutableStateFlow(false)

    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    init {
        fetchHomeAllData()
    }

    internal val viewState = combine(
        homeService.homeBannerFlow,
        homeService.homeTopArticleListFlow,
        homeService.homeHotArticleListFlow,
    ) { homeBanner, homeTopArticle, homeHotArticle ->
        _isRefreshing.value = false
        HomePageViewState.ShowHomeAllData(
            homeAllDataInfo = HomeAllDataInfo(
                homeBanner,
                homeTopArticle,
                homeHotArticle.datas,
            )
        )
    }

    fun fetchHomeAllData() {
        _isRefreshing.value = true
        viewModelScope.launch {
            homeService.fetchHomeTopArticle()
            homeService.fetchHomeHotArticle(0)
            homeService.fetchHomeBanner()
        }
    }

    fun finishRefresh() {
        _isRefreshing.value = false
    }
}