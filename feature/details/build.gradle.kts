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

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
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

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":shared")))

    implementation(Deps.CORE_KTX)
    implementation(Deps.APPCOMPAT)
    implementation(Deps.MATERIAL)

    implementation(Deps.CONSTRAINT_LAYOUT)
    implementation(Deps.RECYCLER_VIEW)
    implementation(Deps.CARDVIEW)

    //viewmodel + livedata
    implementation(Deps.LIFECYCLE_EXT)
    implementation(Deps.LIVEDATA_KTX)
    implementation(Deps.VIEWMODEL_KTX)


    // navigation
    implementation(Deps.NAV_FRAGMENT)
    implementation(Deps.NAV_UI_KTX)


    //retrofit
    implementation(Deps.RETROFIT)
    implementation(Deps.RETROFIT_MOSHI_CONVERTER)
    implementation(Deps.LOGGING_INTERCEPTOR)

    //moshi
    implementation(Deps.MOSHI)
    implementation(Deps.MOSHI_KOTLIN)
    implementation(Deps.MOSHI_ADAPTERS)
    kapt(Deps.MOSHI_KOTLIN_CODEGEN)


    //DI (Hilt)
    implementation(Deps.HILT)
    kapt(Deps.HILT_COMPILER)
//    kapt(Deps.hiltx_compiler)

    // Timber - Logger
    implementation(Deps.TIMBER)

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