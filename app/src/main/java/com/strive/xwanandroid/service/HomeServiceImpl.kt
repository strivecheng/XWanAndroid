package com.strive.xwanandroid.service

import com.strive.xwanandroid.service.data.dto.ArticleResultDto
import com.strive.xwanandroid.service.data.dto.BasePageResultDto
import com.strive.xwanandroid.service.data.dto.HomeBannerResultDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

/**
 * @author strivexing
 * @date 2022/3/23 21:41
 * @description
 */
class HomeServiceImpl(
    private val wanAndroidApi: WanAndroidApi
) : HomeService {
    private val serviceContext = Dispatchers.Default + SupervisorJob()

    override var homeTopArticleListFlow: MutableStateFlow<List<ArticleResultDto>> =
        MutableStateFlow(emptyList())

    override suspend fun fetchHomeTopArticle() {
        withContext(serviceContext) {
            when (val result = wanAndroidApi.fetchHomeTopArticle()) {
                is WanAndroidBffResult.Success -> {
                    homeTopArticleListFlow.value = result.response.map {
                        it.isTop = true
                        it
                    }
                }
                is WanAndroidBffResult.Failure -> {

                }
            }
        }
    }

    override var homeHotArticleListFlow: MutableStateFlow<BasePageResultDto<ArticleResultDto>> =
        MutableStateFlow((BasePageResultDto()))

    override suspend fun fetchHomeHotArticle(page: Int) {
        withContext(serviceContext) {
            when (val result = wanAndroidApi.fetchHomeHotArticle(page = page)) {
                is WanAndroidBffResult.Success -> {
                    homeHotArticleListFlow.value = result.response
                }
                is WanAndroidBffResult.Failure -> {

                }
            }
        }
    }

    override var homeBannerFlow: MutableStateFlow<List<HomeBannerResultDto>> =
        MutableStateFlow(listOf())

    override suspend fun fetchHomeBanner() {
        withContext(serviceContext) {
            when (val result = wanAndroidApi.fetchHomeBanner()) {
                is WanAndroidBffResult.Success -> {
                    homeBannerFlow.value = result.response
                }
                is WanAndroidBffResult.Failure -> {

                }
            }
        }
    }
}