plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("android")
}

/* @formatter:off */
android {
    buildFeatures { viewBinding = true }
    defaultConfig {
        with(Configuration.AppConfigs) {
            compileSdk = compile_sdk_version
            applicationId = application_id
            minSdk = min_sdk_version
            targetSdk = target_sdk_version
            versionCode = version_code
            versionName = version_name
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }
    buildTypes {
        val buildTypeName = sequenceOf("release","debug")
        for (typeName in buildTypeName) {
            getByName(typeName) {
                isMinifyEnabled = false
                isShrinkResources = false
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                signingConfig = signingConfigs.findByName(typeName)
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions { jvmTarget = "1.8" }
}
/* @formatter:on */

dependencies {
    implementation(project(mapOf("path" to ":lib_base")))
    implementation(project(mapOf("path" to ":minebbs")))
}