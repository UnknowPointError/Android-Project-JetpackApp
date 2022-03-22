plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}
android {
    compileSdk = 31
    buildFeatures {
        viewBinding = true
    }
    defaultConfig {
        Configuration.AppConfigs.apply {
            applicationId = application_id
            minSdk = min_sdk_version
            targetSdk = target_sdk_version
            versionCode = version_code
            versionName = version_name
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        /*release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }*/
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.findByName("debug")
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.findByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    implementation(project(mapOf("path" to ":lib_base")))
    implementation(Configuration.Dependencies.android_koin)
    implementation(Configuration.Dependencies.androidx_core)
    implementation(Configuration.Dependencies.androidx_activity)
    implementation(Configuration.Dependencies.androidx_appcompat)
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.appcompat:appcompat:1.2.0")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}