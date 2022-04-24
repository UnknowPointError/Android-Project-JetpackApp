plugins {
    id ("com.android.library")
    id ("kotlin-android")
}
android {
    buildFeatures { viewBinding = true }
    defaultConfig {
        with(Configuration.AppConfigs) {
            resourcePrefix = "base"
            compileSdk = compile_sdk_version
            minSdk = min_sdk_version
            targetSdk = target_sdk_version
        }
    }

    /* Java版本设置 */
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    /* Kotlin 相关配置 */
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    with(Configuration.Dependencies) {
        api(android_koin)
        api(androidx_core)
        api(androidx_activity)
        api(androidx_appcompat)
        api(android_material)
        api(androidx_constraintlayout)
        api(junit_junit)
        api(androidx_test_junit)
        api(androidx_test_espresso)
        api(kotlinx_coroutines)
    }
}