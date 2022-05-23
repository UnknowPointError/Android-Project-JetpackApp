plugins {

    id("com.android.application")

    id("kotlin-parcelize")
    
    kotlin("android")

    kotlin("kapt")

    kotlin("plugin.serialization") version Configuration.Versions.kotlin_version

}


android {

    with(Configuration.AppConfigs) {


        namespace = "cn.barry.jetpackapp"


        buildFeatures { viewBinding = true }


        defaultConfig {
            compileSdk = compile_sdk_version
            applicationId = application_id
            minSdk = min_sdk_version
            targetSdk = target_sdk_version
            versionCode = version_code
            versionName = version_name
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }


        buildTypes {
            val buildTypeName = sequenceOf("release", "debug")
            for (typeName in buildTypeName) {
                getByName(typeName) {
                    isMinifyEnabled = false
                    isShrinkResources = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                    signingConfig = signingConfigs.findByName(typeName)
                }
            }
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

    implementation(project(mapOf("path" to ":lib_base")))
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

}