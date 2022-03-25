package com.strive.xwanandroid.ui.home.data

import com.strive.xwanandroid.service.data.dto.ArticleResultDto
import com.strive.xwanandroid.service.data.dto.HomeBannerResultDto

/**
 * @author strivexing
 * @date 2022/3/24 19:48
 * @description
 */
data class HomeAllDataInfo(
    val bannerList: List<HomeBannerResultDto>,
    val homeTopArticleList: List<ArticleResultDto>,
    val homeHotArticleList: List<ArticleResultDto>
)