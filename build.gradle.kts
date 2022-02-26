// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()

    }
    dependencies {
        classpath(Deps.GRADLE_BUILD_TOOLS)
        classpath(Deps.KOTLIN_GRADLE_PLUGIN)
        classpath(Deps.NAV_SAFE_ARGS_PLUGIN)
        classpath(Deps.HILT_ANDROID_PLUGIN)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {

    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
