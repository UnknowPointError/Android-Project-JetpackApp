@Suppress("UnstableApiUsage")   /* https://cache.one/read/16327826 */
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven("https://www.jitpack.io")
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        maven("https://maven.aliyun.com/nexus/content/repositories/jcenter")
        flatDir { dirs("libs") }
    }
}
rootProject.name = "JetpackApp"
include(":app")
include(":lib_base")
