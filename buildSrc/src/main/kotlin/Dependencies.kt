package com.strive.xwanandroid.buildsrc

/**
 * @author:strivexing
 * @date:2021/8/4 5:30 下午
 * @description:
 */
object Versions {
    const val androidx_appcompat = "1.2.0"
    const val androidx_constraintLayout = "2.0.4"
    const val androidx_coordinatorLayout = "1.1.0"
    const val core_ktx = "1.7.0"
    const val fragment_ktx = "1.4.1"
    const val activity_ktx = "1.4.0"

    const val material = "1.3.0"
    const val gson = "2.8.6"
    const val hilt = "2.30.1-alpha"
    const val dagger_hilt = "1.0.0-alpha02"

    const val gradle_plugin = "7.1.2"

    const val kotlin_coroutines_serialization = "1.2.2"

    const val glide = "4.10.0"

    const val okio = "2.2.2"
    const val retrofit_coroutines = "0.9.2"

    const val junit = "4.13.2"
    const val ext_junit = "1.1.2"
    const val espresso_core = "3.3.0"
}

object Libs {
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.core_ktx}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.androidx_appcompat}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment_ktx}"
        const val activityKtx = "androidx.activity:activity-ktx:${Versions.activity_ktx}"
        const val activityComposeKtx = "androidx.activity:activity-compose:${Versions.activity_ktx}"
        const val dynamicAnimationKtx = "androidx.dynamicanimation:dynamicanimation-ktx"

        object Lifecycle {
            private const val version = "2.4.1"
            const val lifecycleCommon = "androidx.lifecycle:lifecycle-common:${version}"
            const val lifecycleCommonJava8 =
                "androidx.lifecycle:lifecycle-common-java8:${version}"
            const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${version}"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${version}"
            const val viewModelSavedState =
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:${version}"
            const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${version}"
        }

        object Room {
            private const val version = "2.4.2"
            const val roomCompiler = "androidx.room:room-compiler:${version}"
            const val roomRuntime = "androidx.room:room-runtime:${version}"
            const val roomKtx = "androidx.room:room-ktx:${version}"
            const val roomPaging3 = "androidx.room:room-paging:2.4.0-alpha04"
            const val roomRxJava3 = "androidx.room:room-rxjava3:${version}"
        }

        object Navigation {
            private const val version = "2.4.0"
            const val runTimeKtx =
                "androidx.navigation:navigation-runtime-ktx:${version}"
            const val compose = "androidx.navigation:navigation-compose:$version"
            const val fragmentKtx =
                "androidx.navigation:navigation-fragment-ktx:${version}"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:${version}"
        }

        object Compose {
            const val version = "1.1.1"
            const val compiler = "androidx.compose.compiler:compiler:${version}"
            const val runtime = "androidx.compose.runtime:runtime:${version}"
            const val ui = "androidx.compose.ui:ui:${version}"
            const val uiTooling = "androidx.compose.ui:ui-tooling:${version}"
            const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${version}"
            const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4:${version}"
            const val foundation = "androidx.compose.foundation:foundation:${version}"
            const val material = "androidx.compose.material:material:${version}"
            const val materialIconsCore =
                "androidx.compose.material:material-icons-core:${version}"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:${version}"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:${version}"
            const val themeAdapter =
                "com.google.android.material:compose-theme-adapter:${version}"
            const val activity = "androidx.activity:activity-compose:1.3.0-alpha08"
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha05"
        }

        object Paging {
            const val version = "3.1.1"
            const val composeVersion = "1.0.0-alpha15"
            const val runtime = "androidx.paging:paging-runtime:$version"
            const val common = "androidx.paging:paging-common:$version"
            const val compose = "androidx.paging:paging-compose:$composeVersion"
        }


        //WorkManager
        const val workManager = "androidx.work:work-runtime-ktx:2.5.0"
        const val browser = "androidx.browser:browser:1.4.0"
    }

    object Accompanist {
        const val version = "0.23.1"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val systemUiController =
            "com.google.accompanist:accompanist-systemuicontroller:$version"
        const val flowlayouts = "com.google.accompanist:accompanist-flowlayout:$version"
        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val permissions = "com.google.accompanist:accompanist-permissions:$version"
        const val navigationAnimation =
            "com.google.accompanist:accompanist-navigation-animation:$version"
        const val swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:$version"
    }


    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
    const val coordinatorLayout =
        "androidx.coordinatorlayout:coordinatorlayout:${Versions.androidx_coordinatorLayout}"

    //Google
    const val material = "com.google.android.material:material:${Versions.material}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val multidex = "androidx.multidex:multidex"

    //Gradle
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradle_plugin}"

    object Kotlin {
        private const val version = "1.6.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val serializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${version}"
    }

    object Coroutines {
        private const val version = "1.6.0"
        const val core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${version}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${version}"
        const val serializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlin_coroutines_serialization}"
        const val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.2.2"
    }

    object Ktor {
        private const val version = "1.6.8"
        const val android = "io.ktor:ktor-client-android:${version}"
        const val coreJvm = "io.ktor:ktor-client-core:${version}"
        const val okHttp = "io.ktor:ktor-client-okhttp:${version}"
        const val logging = "io.ktor:ktor-client-logging:${version}"
        const val loggingJvm = "io.ktor:ktor-client-logging-jvm:${version}"
        const val jsonFeature = "io.ktor:ktor-client-json:${version}"
        const val serialization = "io.ktor:ktor-client-serialization:${version}"
        const val gson = "io.ktor:ktor-client-gson:${version}"
        const val encoding = "io.ktor:ktor-client-encoding:${version}"
        const val mockEngine = "io.ktor:ktor-client-mock:${version}"
        const val mockEngineJvm = "io.ktor:ktor-client-mock-jvm:${version}"
    }

    object Koin {
        private const val version = "3.1.5"
        const val core = "io.insert-koin:koin-core:${version}"
        const val android = "io.insert-koin:koin-android:${version}"
        const val androidCompose = "io.insert-koin:koin-androidx-compose:${version}"
        const val androidViewModel = "io.insert-koin:koin-android-viewmodel:${version}"
        const val navigation = "io.insert-koin:koin-androidx-navigation:${version}"
        const val ktor = "io.insert-koin:koin-ktor:${version}"
        const val logger = "io.insert-koin:koin-logger-slf4j:${version}"
        const val test = "io.insert-koin:koin-test:${version}"
        const val testJunit4 = "io.insert-koin:koin-test-junit4:${version}"
    }

    object Coil {
        private const val version = "2.0.0-rc02"
        const val coil = "io.coil-kt:coil:${version}"
        const val coilCompose = "io.coil-kt:coil-compose:${version}"
        const val coilGif = "io.coil-kt:coil-gif:${version}"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:${version}"
        const val retrofit_rxjava_adapter =
            "com.squareup.retrofit2:adapter-rxjava2:${version}"
        const val retrofit_converter = "com.squareup.retrofit2:converter-gson:${version}"
    }

    object OkHttp3 {
        private const val version = "4.9.0"
        const val okhttp3 = "com.squareup.okhttp3:okhttp:${version}"
    }

    object AgentWeb {
        private const val version = "v5.0.0-alpha.1-androidx"
        const val core = "com.github.Justson.AgentWeb:agentweb-core:${version}"
        const val fileChooser =
            "com.github.Justson.AgentWeb:agentweb-filechooser:${version}" // (可选)
        const val downloader = "com.github.Justson:Downloader:v5.0.0-androidx"

    }

    const val slf4j = "org.slf4j:slf4j-simple:1.7.32"
    const val okio = "com.squareup.okio:okio:${Versions.okio}"

    //Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    //    const val glide_okhttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide_okhttp}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
//    const val glide_transformations = "jp.wasabeef:glide-transformations:${Versions.glide_transformations}"

    //Test
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.ext_junit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
//    testImplementation 'io.mockk:mockk:1.8.6'


    object AppCenter {
        private const val version = "4.1.0"
        const val distribute =
            "com.microsoft.appcenter:appcenter-distribute:${version}"
        const val analytics =
            "com.microsoft.appcenter:appcenter-analytics:${version}"
        const val crashes =
            "com.microsoft.appcenter:appcenter-crashes:${version}"
    }

    //Third Library
    const val baseAdapter = "com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.4"
}