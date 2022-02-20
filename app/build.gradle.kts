plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android-extensions")
    id("dagger.hilt.android.plugin")
}



//val keystoreProperties = Properties().apply {
//    load(FileInputStream(File(rootProject.rootDir, "keystore.properties")))
//}


android {
    compileSdkVersion(AppConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId(AppConfig.APP_NAME)
        minSdkVersion(AppConfig.MIN_SDK_VERSION)
        targetSdkVersion(AppConfig.TARGER_SDK_VERSION)
        versionCode(AppConfig.VERSION_CODE)
        versionName(AppConfig.VERSION_NAME)
        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        buildConfigField("String", "BASE_URL", "\"https://api.github.com/\"")


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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(mapOf("path" to ":shared")))

    implementation(Deps.KOTLIN)
    implementation(Deps.APPCOMPAT)
    implementation(Deps.CORE_KTX)
    implementation(Deps.CONSTRAINT_LAYOUT)
    implementation(Deps.RECYCLER_VIEW)
    implementation(Deps.MATERIAL)
    implementation(Deps.CARDVIEW)
    implementation(Deps.FRAGMENT_KTX)

    //viewmodel + livedata
    implementation(Deps.LIFECYCLE_EXT)
    implementation(Deps.LIVEDATA_KTX)
    implementation(Deps.VIEWMODEL_KTX)

    implementation(Deps.PAGING)

    //retrofit
    implementation(Deps.RETROFIT)
    implementation(Deps.RETROFIT_MOSHI_CONVERTER)
    implementation(Deps.RETROFIT_RX_JAVA_ADAPTER)
    implementation(Deps.LOGGING_INTERCEPTOR)

    //rx android
    implementation(Deps.RX_ANDROID)
    implementation(Deps.RX_JAVA)

    //databinding
    implementation(Deps.DATABINDING_COMMON)

    //moshi
    implementation(Deps.MOSHI)
    implementation(Deps.MOSHI_KOTLIN)
    implementation(Deps.MOSHI_ADAPTERS)
    implementation("androidx.paging:paging-rxjava2-ktx:3.1.0")
    kapt(Deps.MOSHI_KOTLIN_CODEGEN)




    //DI (Hilt)
    implementation(Deps.HILT)
    kapt(Deps.HILT_COMPILER)
//    kapt(Deps.hiltx_compiler)


    // Kotlin
    implementation(Deps.NAV_FRAGMENT)
    implementation(Deps.NAV_UI_KTX)

    // Feature module Support
    implementation(Deps.NAV_DYNAMIC_FEATURES)

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
    androidTestImplementation(Deps.JUNIT_EXT)
    androidTestImplementation(Deps.ESPRESSO_CORE)
    androidTestImplementation(Deps.ESPRESSO_CONTRIB)
    debugImplementation(Deps.FRAGMENT_TESTING)

    androidTestImplementation(Deps.JW_IDLING_RESOURCE)
    androidTestImplementation(Deps.BARISTA) {
        exclude("org.jetbrains", "kotlin")
    }

}
