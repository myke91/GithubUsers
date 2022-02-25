plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(AppConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        minSdkVersion(AppConfig.MIN_SDK_VERSION)
        targetSdkVersion(AppConfig.TARGER_SDK_VERSION)
        versionCode(AppConfig.VERSION_CODE)
        versionName(AppConfig.VERSION_NAME)
        consumerProguardFiles("consumer-rules.pro")

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
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
    implementation(Deps.APPCOMPAT)
    implementation(Deps.CORE_KTX)
    implementation(Deps.MATERIAL)
    implementation(Deps.PICASSO)


    //courotines
    implementation(Deps.KOTLIN_COROUTINE_CORE)
    implementation(Deps.KOTLIN_COROUTINE_ANDROID)

    testImplementation(Deps.JUNIT)
    androidTestImplementation(Deps.JUNIT_KTX)
    androidTestImplementation(Deps.ESPRESSO_CORE)

    implementation(Deps.KOTLIN)
    implementation(Deps.APPCOMPAT)

    implementation(Deps.PAGING)

    //retrofit
    implementation(Deps.RETROFIT)
    implementation(Deps.RETROFIT_MOSHI_CONVERTER)
    implementation(Deps.LOGGING_INTERCEPTOR)

    //courotines
    implementation(Deps.KOTLIN_COROUTINE_CORE)
    implementation(Deps.KOTLIN_COROUTINE_ANDROID)


    //moshi
    implementation(Deps.MOSHI)
    implementation(Deps.MOSHI_KOTLIN)
    implementation(Deps.MOSHI_ADAPTERS)
    kapt(Deps.MOSHI_KOTLIN_CODEGEN)


    //DI (Hilt)
    implementation(Deps.HILT)
    kapt(Deps.HILT_COMPILER)
//    kapt(Deps.hiltx_compiler)

    // Kotlin
    implementation(Deps.NAV_FRAGMENT)
    implementation(Deps.NAV_UI_KTX)

    //idling resource
    implementation(Deps.ESPRESSO_IDLING_RESOURCE)
    implementation(Deps.JW_IDLING_RESOURCE)


    // Timber - Logger
    implementation(Deps.TIMBER)

    // Testing Navigation
    androidTestImplementation(Deps.NAV_TESTING)


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