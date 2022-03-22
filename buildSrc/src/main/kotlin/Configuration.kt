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
        const val min_sdk_version = 21

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
        const val core_version = "1.3.2"
        const val activity_version = "1.4.0"
    }

    /* 依赖 */
    object Dependencies {
        const val android_koin = "io.insert-koin:koin-android:3.2.0-beta-1"
        const val androidx_core = "androidx.core:core-ktx:1.3.2"
        const val androidx_activity = "androidx.activity:activity-ktx:1.4.0"
        const val androidx_appcompat = "androidx.appcompat:appcompat:1.4.1"
    }
}