plugins {
    id("com.android.library")
    id("kotlin-android")
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
}