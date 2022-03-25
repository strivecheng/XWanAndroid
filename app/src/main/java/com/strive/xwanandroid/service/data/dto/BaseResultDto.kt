package com.strive.xwanandroid.service.data.dto

import kotlinx.serialization.Serializable

/**
 * @author strivexing
 * @date 2022/3/24 16:40
 * @description
 */
@Serializable
data class BaseResultDto<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String,
)

@Serializable
data class BasePageResultDto<T>(
    val curPage: Int? = 0,
    val datas: List<T> = emptyList(),
    val offset: Int? = 0,
    val over: Boolean? = false,
    val pageCount: Int? = 0,
    val size: Int? = 0,
    val total: Int? = 0
)
