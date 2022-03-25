package com.strive.xwanandroid.service

import com.strive.xwanandroid.service.data.dto.ArticleResultDto
import com.strive.xwanandroid.service.data.dto.BasePageResultDto
import com.strive.xwanandroid.service.data.dto.HomeBannerResultDto
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @author strivexing
 * @date 2022/3/23 21:37
 * @description 首页相关数据
 */
interface HomeService {

    var homeTopArticleListFlow: MutableStateFlow<List<ArticleResultDto>>
    suspend fun fetchHomeTopArticle()

    var homeHotArticleListFlow: MutableStateFlow<BasePageResultDto<ArticleResultDto>>
    suspend fun fetchHomeHotArticle(page: Int)

    var homeBannerFlow: MutableStateFlow<List<HomeBannerResultDto>>
    suspend fun fetchHomeBanner()
}