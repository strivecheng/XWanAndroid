package com.strive.xwanandroid.service

import com.strive.xwanandroid.service.data.dto.ArticleResultDto
import com.strive.xwanandroid.service.data.dto.BasePageResultDto
import com.strive.xwanandroid.service.data.dto.HomeBannerResultDto
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

/**
 * @author strivexing
 * @date 2022/3/23 21:47
 * @description
 */

class WanAndroidApi(httpClient: HttpClient) {
    private val client = httpClient.config {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
                encodeDefaults = true
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    suspend fun fetchHomeHotArticle(page: Int): WanAndroidBffResult<BasePageResultDto<ArticleResultDto>> =
        receiveWanAndroidBffResult {
            client.get("article/list/$page/json")
        }

    suspend fun fetchHomeTopArticle(): WanAndroidBffResult<List<ArticleResultDto>> =
        receiveWanAndroidBffResult {
            client.get("article/top/json")
        }

    suspend fun fetchHomeBanner(): WanAndroidBffResult<List<HomeBannerResultDto>> =
        receiveWanAndroidBffResult {
            client.get("banner/json")
        }
}

