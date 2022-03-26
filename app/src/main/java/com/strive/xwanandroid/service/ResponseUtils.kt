package com.strive.xwanandroid.service

import com.strive.xwanandroid.service.data.dto.BaseResultDto
import io.ktor.client.call.receive
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

/**
 * @author strivexing
 * @date 2022/3/24 17:16
 * @description
 */
internal suspend inline fun <reified DTO> receiveWanAndroidBffResult(
    block: () -> HttpResponse
): WanAndroidBffResult<DTO> = runCatchingOrError {
    val response = block()
    return if (response.status.isSuccess()) {
        // Try to parse the response
        try {
            val baseResultDto = response.receive<BaseResultDto<DTO>>()
            if (baseResultDto.errorCode == 0) {
                WanAndroidBffResult.Success(baseResultDto.data)
            } else {
                WanAndroidBffResult.Failure(
                    errorInfo = WanAndroidBffError(
                        message = baseResultDto.errorMsg,
                        code = baseResultDto.errorCode,
                    )
                )
            }
        } catch (e: Exception) {
            WanAndroidBffResult.Failure(
                errorInfo = WanAndroidBffError(
                    e.message ?: "",
                    e.hashCode(),
                )
            )
        }
    } else {
        WanAndroidBffResult.Failure(
            errorInfo = WanAndroidBffError(
                response.receive(),
                response.status.value,
            )
        )
    }
}


internal inline fun <T> runCatchingOrError(block: () -> WanAndroidBffResult<T>): WanAndroidBffResult<T> =
    runCatching { block() }.getOrElse {
        WanAndroidBffResult.Failure(
            WanAndroidBffError(
                message = it.message ?: "",
                code = -1,
            )
        )
    }