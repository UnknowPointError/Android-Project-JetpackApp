/* Top-level build file where you can add configuration options common to all sub-projects/modules.
 * buildscript提供环境去声明的资源包括依赖项、第三方插件、maven仓库地址等 */
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.android.tools.build:gradle:7.2.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://www.jitpack.io")
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        maven("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        flatDir { dirs("libs") }
    }
}