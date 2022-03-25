package com.strive.xwanandroid

import com.strive.xwanandroid.service.HomeService
import com.strive.xwanandroid.service.HomeServiceImpl
import com.strive.xwanandroid.service.WanAndroidApi
import com.strive.xwanandroid.ui.home.HomeViewModel
import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.URLBuilder
import io.ktor.http.Url
import io.ktor.http.takeFrom
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author strivexing
 * @date 2022/3/23 19:23
 * @description
 */
internal val basePath = Url("https://www.wanandroid.com/")

val appModules = module {
    single<HttpClient> {
        HttpClient {
            defaultRequest {
                url.takeFrom(URLBuilder().takeFrom(basePath).apply {
                    encodedPath += url.encodedPath
                })
                header("version", "1.0")
            }
        }
    }
    single { WanAndroidApi(get()) }
    single<HomeService> { HomeServiceImpl(get()) }
    viewModel { HomeViewModel(get()) }

}