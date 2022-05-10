/* Top-level build file where you can add configuration options common to all sub-projects/modules.
 * buildscript提供环境去声明的资源包括依赖项、第三方插件、maven仓库地址等 */

buildscript {
    repositories {
        google()
        mavenCentral()
        flatDir { dirs("libs") }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
        /* NOTE: Do not place your application dependencies here; they belong
         * in the individual module build.gradle files */
    }
}
task("cleanAll") { delete(rootProject.buildDir) }
task("printStringClass") {
    println("Hello,World.")
}