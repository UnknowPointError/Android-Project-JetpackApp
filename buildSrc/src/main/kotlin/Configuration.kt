/*************************
 * @Machine: RedmiBook Pro 15
 * @RelativePath: Configuration.kt
 * @Path: D:\Barry\B_study\Android\Android_Project\JetpackApp\buildSrc\src\main\kotlin\Configuration.kt
 * @Author: Barry
 * @Time: 2022/5/6 9:18 周五 上午
 * @Description: 项目配置
 * @formatter:off
 *************************/

object Configuration {

    /* 应用配置 */
    object AppConfigs {

        /* 应用ID */
        const val application_id = "cn.barry.jetpackapp"

        /* 编译SDK版本 Android 12 */
        const val compile_sdk_version = 31

        /* 编译工具版本 */
        const val build_tools_version = "31.0.0"

        /* 最小支持版本 Android 6 */
        const val min_sdk_version = 23

        /* 目标支持版本 Android 12 */
        const val target_sdk_version = 31

        /* 应用版本号 */
        const val version_code = 1

        /* 应用版本名 */
        const val version_name = "1.0.0"

        /* 是否单独运行模块 */
        const val isSingleModule = false

    }

    /* 版本 */
    object Versions {
        const val kotlin_version = "1.6.21"
        const val core_version = "1.7.0"
        const val activity_version = "1.4.0"
        const val smart_refresh = "2.0.5"
        const val retrofit_version = "2.9.0"
        const val arouter_version = "1.5.2"
        const val okhttp_version = "4.9.3"
        const val navigation_version = "2.4.2"
        const val glide_version = "4.13.1"
        const val lifecycle_version = "2.4.1"
    }

    /* 依赖 */
    object Dependencies {

        /* 针对最新的平台功能和 API 调整应用,同时还支持旧设备
        * - Jetpack : [https://developer.android.google.cn/jetpack/androidx/releases/core?hl=zh-cn]
        * */
        const val androidx_core = "androidx.core:core-ktx:${Versions.core_version}"

        /* 允许在平台的旧版 API 上访问新 API（很多使用 Material Design）*/
        const val androidx_appcompat = "androidx.appcompat:appcompat:1.4.1"

        /* 访问基于 Activity 构建的可组合 API */
        const val androidx_activity = "androidx.activity:activity-ktx:1.4.0"

        /* JUnit 是一个编写可重复测试的简单框架。它是用于单元测试框架的 xUnit 架构的一个实例
        * - Github : [https://github.com/junit-team/junit4]
        * */
        const val junit_junit = "junit:junit:4.13.2"

        /* 在 Android 中进行测试 */
        const val androidx_test_junit = "androidx.test.ext:junit-ktx:1.1.3"
        const val androidx_test_espresso = "androidx.test.espresso:espresso-core:3.4.0"

        /* androidx lifecycle */
        const val androidx_lifecycle_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
        const val androidx_lifecycle_service = "androidx.lifecycle:lifecycle-service:${Versions.lifecycle_version}"
        const val androidx_lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
        const val androidx_lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
        /* 使用“相对定位(约束布局)”灵活地确定控件的位置和大小 */
        const val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.3"

        /* Material Design 界面组件
        * - MvnRepository : [https://mvnrepository.com/artifact/com.google.android.material/material]
        * */
        const val android_material = "com.google.android.material:material:1.6.0"

        /* Kotlin Android 注入库
        * - Home : [https://insert-koin.io/]
        * */
        const val android_koin = "io.insert-koin:koin-android:3.1.6"

        /* Coroutine 协程
        * - GitHub : [https://github.com/Kotlin/kotlinx.coroutines]
        * */
        const val kotlinx_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1"

        /* SmartRefresh
        * - GitHub : [https://github.com/scwang90/SmartRefreshLayout]
        * */
        const val smart_refresh = "io.github.scwang90:refresh-layout-kernel:${Versions.smart_refresh}" // 核心依赖
        const val smart_refresh_header = "io.github.scwang90:refresh-header-classics:${Versions.smart_refresh}" //经典刷新头
        const val smart_refresh_radar = "io.github.scwang90:refresh-header-radar:${Versions.smart_refresh}"     //雷达刷新头

        /* Swiperefreshlayout */
        const val androidx_swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

        /* Retrofit 库依赖
        * - Github: [https://github.com/square/retrofit]
        * */
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
        const val retrofit_gson =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"

        /* ARouter 路由
        * - Github: [https://github.com/alibaba/ARouter]
        * */
        const val arouter_api = "com.alibaba:arouter-api:${Versions.arouter_version}"
        const val arouter_compiler = "com.alibaba:arouter-compiler:${Versions.arouter_version}"

        /* kotlin Json 序列化
        * - Github: [https://github.com/Kotlin/kotlinx.serialization]
        * */
        const val kotlin_serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1"


        /* okhttp 网络Http客户端
        * - Github : [https://github.com/square/okhttp]
        * */
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp_version}"
        const val okhttp_urlconnection = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okhttp_version}"
        const val okhttp_loggin = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_version}"

        /* Logger 日志打印
        * - Github: [https://github.com/orhanobut/logger]
        * */
        const val logger = "com.orhanobut:logger:2.2.0"

        /* lottie动画
        * - Github: [https://github.com/airbnb/lottie-android]
        * */
        const val lottie = "com.airbnb.android:lottie:5.1.1"

        /* navigation fragment 导航碎片
        * - Home : [https://developer.android.google.cn/jetpack/androidx/releases/navigation?hl=en]
        * */
        const val androidx_navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation_version}"
        const val androidx_navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation_version}"

        /* leakcanary 内存泄漏检查工具
        * - Github : [https://github.com/square/leakcanary]
        * */
        const val leakcanary ="com.squareup.leakcanary:leakcanary-android:2.9.1"

        /* Glide 图片加载
        * - Github : [https://github.com/bumptech/glide]
        * */
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"
        const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide_version}"

        /* PhotoView
        * - Github : [https://github.com/Baseflow/PhotoView]
        * */
        const val photoview = "com.github.chrisbanes:PhotoView:2.0.0"

        /* Volley 网络请求
        * - Home : [https://developer.android.google.cn/training/volley?hl=zh-cn]
        * */
        const val volley = "com.android.volley:volley:1.1.1"

        /* 闪光布局
        * - Github : [https://github.com/team-supercharge/ShimmerLayout]
        * */
        const val shimmerlayout = "io.supercharge:shimmerlayout:2.1.0"

        /* 屏幕适配
        * - Github : [https://github.com/JessYanCoding/AndroidAutoSize]
        * */
        const val autosize = "com.github.JessYanCoding:AndroidAutoSize:v1.2.1"
    }

    object Plugins {
        const val android_application = "com.android.application"
        const val android_library = "com.android.library"
        const val androidx_navigation_safeargs = "androidx.navigation.safeargs"

        const val kapt = "kapt"
        const val kotlin_parcelize = "kotlin-parcelize"
        const val serialization = "plugin.serialization"
    }
}