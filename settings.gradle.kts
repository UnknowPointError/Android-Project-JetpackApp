dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://www.jitpack.io")
        jcenter() // Warning: this repository is going to shut down soon
    }
}
include(":app")
include(":lib_base")
include(":minebbs")
