plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(AppConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId(AppConfig.APP_NAME)
        minSdkVersion(AppConfig.MIN_SDK_VERSION)
        targetSdkVersion(AppConfig.TARGER_SDK_VERSION)
        versionCode(AppConfig.VERSION_CODE)
        versionName(AppConfig.VERSION_NAME)
        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("debug") {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(mapOf("path" to ":shared")))
    implementation(project(mapOf("path" to ":feature:user")))
    implementation(project(mapOf("path" to ":feature:details")))

    implementation(Deps.CONSTRAINT_LAYOUT)

    //jetpack navigation
    implementation(Deps.NAV_FRAGMENT)
    implementation(Deps.NAV_UI_KTX)
    implementation(Deps.NAV_DYNAMIC_FEATURES)

    //DI (Hilt)
    implementation(Deps.HILT)
    kapt(Deps.HILT_COMPILER)
//    kapt(Deps.hiltx_compiler)



    //test
    testImplementation(Deps.JUNIT)
    testImplementation(Deps.MOCKITO_CORE)
    testImplementation(Deps.CORE_TESTING)
    testImplementation(Deps.MOCKITO_INLINE)
    testImplementation(Deps.MOCKITO_KOTLIN)
    testImplementation(Deps.KOTLINX_COROUTINE_TEST)

    //android instrumentation
    androidTestImplementation(Deps.TEST_RUNNER)
    androidTestImplementation(Deps.ANDROID_TEST_JUNIT)
    androidTestImplementation(Deps.ESPRESSO_CORE)

    androidTestImplementation(Deps.JW_IDLING_RESOURCE)
    androidTestImplementation(Deps.BARISTA) {
        exclude("org.jetbrains", "kotlin")
    }

}
