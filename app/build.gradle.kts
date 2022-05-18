plugins {
    id(Configuration.Plugins.android_application)
    id(Configuration.Plugins.kotlin_parcelize)
    id("kotlin-android")
    kotlin("android")
    kotlin(Configuration.Plugins.kapt)
    kotlin(Configuration.Plugins.serialization) version Configuration.Versions.kotlin_version
}
/* @formatter:off */
android {
    namespace = "cn.barry.jetpackapp"
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
    @Suppress("UnstableApiUsage")
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xcontext-receivers")
    }
}

dependencies {
    implementation(project(mapOf("path" to ":lib_base")))
    implementation(project(mapOf("path" to ":minebbs")))
}