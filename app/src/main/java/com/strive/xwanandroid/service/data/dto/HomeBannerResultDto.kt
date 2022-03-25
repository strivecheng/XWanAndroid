package com.strive.xwanandroid.service.data.dto

import kotlinx.serialization.Serializable

/**
 * @author strivexing
 * @date 2022/3/24 19:03
 * @description
 */

@Serializable
data class HomeBannerResultDto(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)
