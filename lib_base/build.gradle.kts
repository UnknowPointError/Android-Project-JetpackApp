plugins {

    id("com.android.library")

    kotlin("android")

}


android {

    with(Configuration.AppConfigs) {


        namespace = "com.barry.base"


        buildFeatures { viewBinding = true }


        defaultConfig {
            resourcePrefix = "base"
            compileSdk = compile_sdk_version
            minSdk = min_sdk_version
            targetSdk = target_sdk_version
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }


        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }


        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = free_compiler_Args
        }


    }

}


dependencies {

    with(Configuration.Dependencies) {
        api(android_koin)
        api(androidx_core)
        api(androidx_activity)
        api(androidx_appcompat)
        api(android_material)
        api(androidx_constraintlayout)
        api(androidx_lifecycle_ktx)
        api(androidx_lifecycle_service)
        api(androidx_lifecycle_livedata_ktx)
        api(androidx_lifecycle_viewmodel_ktx)
        api(kotlinx_coroutines)
        api(smart_refresh)
        api(smart_refresh_header)
        api(smart_refresh_radar)
        api(androidx_swiperefreshlayout)
        api(retrofit)
        api(retrofit_gson)
        api(kotlin_serialization)
        api(okhttp)
        api(okhttp_loggin)
        api(logger)
        api(lottie)
        api(androidx_navigation_ui_ktx)
        api(androidx_navigation_fragment_ktx)
        api(glide)
        api(glide_compiler)
        api(photoview)
        api(volley)
        api(shimmerlayout)
        api(autosize)

        debugApi(leakcanary)
        testApi(junit_junit)
        androidTestApi(androidx_test_junit)
        androidTestApi(androidx_test_espresso)
    }

}