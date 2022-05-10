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
kapt {
    arguments { arg("AROUTER_MODULE_NAME", project.name) }
}


dependencies {
    implementation(project(mapOf("path" to ":lib_base")))
    implementation(project(mapOf("path" to ":minebbs")))

    api(Configuration.Dependencies.arouter_api)
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(Configuration.Dependencies.arouter_compiler)
}