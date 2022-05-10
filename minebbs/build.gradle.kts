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
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    implementation(project(mapOf("path" to ":lib_base")))
}