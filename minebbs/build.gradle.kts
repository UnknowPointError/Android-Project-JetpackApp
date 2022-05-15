plugins {
    with(Configuration.Plugins) {
        id(android_library)
        id("kotlin-android")
    }
}

android {
    buildFeatures { viewBinding = true }
    with(Configuration.AppConfigs) {
        compileSdk = compile_sdk_version
        defaultConfig {
            minSdk = min_sdk_version
            targetSdk = target_sdk_version
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFiles("consumer-rules.pro")
        }
        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
        @Suppress("UnstableApiUsage")
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    namespace = "com.barry.minebbs"
}

dependencies {
    implementation(project(mapOf("path" to ":lib_base")))
}