package com.strive.xwanandroid.service

import kotlinx.serialization.Serializable

/**
 * @author strivexing
 * @date 2022/3/24 17:17
 * @description
 */
sealed class WanAndroidBffResult<T> {
    data class Success<T>(val response: T) : WanAndroidBffResult<T>()
    data class Failure<T>(val errorInfo: WanAndroidBffError) : WanAndroidBffResult<T>()
}

@Serializable
data class WanAndroidBffError(
    val message: String,
    val code: Int,
)
