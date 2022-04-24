/**
 * 项目配置
 */
object Configuration {

    /* 应用配置 */
    object AppConfigs {

        /* 应用ID */
        const val application_id = "cn.barry.jetpackapp"

        /* 编译SDK版本 */
        const val compile_sdk_version = 31

        /* 编译工具版本 */
        const val build_tools_version = "31.0.0"

        /* 最小支持版本 */
        const val min_sdk_version = 23

        /* 目标支持版本 */
        const val target_sdk_version = 31

        /* 应用版本号 */
        const val version_code = 1

        /* 应用版本名 */
        const val version_name = "1.0.0"

        /* 是否单独运行模块 */
        const val isSingleModule = false

    }
    object Versions {
        const val core_version = "1.7.0"
        const val activity_version = "1.4.0"
    }
    /* 依赖 */
    object Dependencies {
        /* 针对最新的平台功能和 API 调整应用,同时还支持旧设备
        *  - Jetpack : [https://developer.android.google.cn/jetpack/androidx/releases/core?hl=zh-cn]
        * */
        const val androidx_core = "androidx.core:core-ktx:${Versions.core_version}"
        /* 允许在平台的旧版 API 上访问新 API（很多使用 Material Design）*/
        const val androidx_appcompat = "androidx.appcompat:appcompat:1.4.1"

        /* 访问基于 Activity 构建的可组合 API */
        const val androidx_activity = "androidx.activity:activity-ktx:1.4.0"

        /* JUnit 是一个编写可重复测试的简单框架。它是用于单元测试框架的 xUnit 架构的一个实例
        *  - Github : [https://github.com/junit-team/junit4]
        * */
        const val junit_junit = "junit:junit:4.13.2"

        /* 在 Android 中进行测试 */
        const val androidx_test_junit = "androidx.test.ext:junit-ktx:1.1.3"
        const val androidx_test_espresso = "androidx.test.espresso:espresso-core:3.4.0"

        /* 使用“相对定位(约束布局)”灵活地确定控件的位置和大小 */
        const val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.3"

        /* Material Design 界面组件
        * - MvnRepository : [https://mvnrepository.com/artifact/com.google.android.material/material]
        * */
        const val android_material = "com.google.android.material:material:1.5.0"

        /* Kotlin Android 注入库
        * - Home : [https://insert-koin.io/]
        * */
        const val android_koin = "io.insert-koin:koin-android:3.1.6"


        /* Coroutine 协程
        * - GitHub : [https://github.com/Kotlin/kotlinx.coroutines]
        * */
        const val kotlinx_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1"
    }
}