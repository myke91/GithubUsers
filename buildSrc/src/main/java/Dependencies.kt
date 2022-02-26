object Vers {
    const val roomPagingVersion = "2.5.0-alpha01"
    const val timberVersion = "4.7.1"
    const val kotlinVersion = "1.6.10"
    const val appcompatVersion = "1.3.1"
    const val constraintlayoutVersion = "2.0.4"
    const val coreKtxVersion = "1.6.0"
    const val lifecycleVersion = "2.4.0"
    const val navigationVersion = "2.3.0"
    const val recyclerviewVersion = "1.2.1"
    const val materialVersion = "1.5.0"
    const val retrofitVersion = "2.9.0"
    const val moshiVersion = "1.12.0"
    const val hiltVersion = "2.40.5"
    const val okhttp3Version = "4.2.1"
    const val databindingVersion = "7.0.4"
    const val androidArchVersion = "1.1.1"
    const val coroutineVersion = "1.6.0"
    const val espressoVersion = "3.4.0"
    const val jwIdlingResourceVersion = "1.0.0"
    const val cardviewVersion = "1.0.0"
    const val fragmentKtxVersion = "1.4.1"
    const val picassoVersion = "2.71828"
    const val junitVersion = "4.13.2"
    const val mockitoCoreVersion = "3.12.4"
    const val coreTestingVersion = "1.1.1"
    const val mockitoInlineVersion = "2.13.0"
    const val kotlinxCourotineTestVersion = "1.4.2"
    const val testRunnerVersion = "1.4.1-alpha03"
    const val androidTestJunitVersion = "1.1.3"
    const val junitKtxVersion = "1.1.3"
    const val gradleVersion = "4.2.2"
    const val mockitoKotlinVersion = "2.1.0"
    const val baristaVersion = "3.6.0"
    const val pagingVersion = "3.1.0"
    const val roomVersion = "2.4.2"
}

object Deps {
    const val ROOM_KTX = "androidx.room:room-ktx:${Vers.roomVersion}"
    const val ROOM_PAGING = "androidx.room:room-paging:${Vers.roomPagingVersion}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Vers.roomVersion}"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Vers.roomVersion}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${Vers.pagingVersion}"
    const val TIMBER = "com.jakewharton.timber:timber:${Vers.timberVersion}"
    const val HILT_ANDROID_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Vers.hiltVersion}"
    const val BARISTA = "com.schibsted.spain:barista:${Vers.baristaVersion}"
    const val MOCKITO_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Vers.mockitoKotlinVersion}"
    const val GRADLE_BUILD_TOOLS = "com.android.tools.build:gradle:${Vers.gradleVersion}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Vers.kotlinVersion}"
    const val NAV_SAFE_ARGS_PLUGIN =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Vers.navigationVersion}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Vers.kotlinVersion}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Vers.appcompatVersion}"
    const val CORE_KTX = "androidx.core:core-ktx:${Vers.coreKtxVersion}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Vers.constraintlayoutVersion}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Vers.recyclerviewVersion}"
    const val MATERIAL = "com.google.android.material:material:${Vers.materialVersion}"
    const val CARDVIEW = "androidx.cardview:cardview:${Vers.cardviewVersion}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Vers.fragmentKtxVersion}"
    const val LIFECYCLE_EXT = "android.arch.lifecycle:extensions:${Vers.androidArchVersion}"
    const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Vers.lifecycleVersion}"
    const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Vers.lifecycleVersion}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Vers.retrofitVersion}"
    const val RETROFIT_MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Vers.retrofitVersion}"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Vers.okhttp3Version}"
    const val KOTLIN_COROUTINE_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Vers.coroutineVersion}"
    const val KOTLIN_COROUTINE_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Vers.coroutineVersion}"
    const val DATABINDING_COMMON = "androidx.databinding:databinding-common:${Vers.databindingVersion}"
    const val MOSHI = "com.squareup.moshi:moshi:${Vers.moshiVersion}"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${Vers.moshiVersion}"
    const val MOSHI_ADAPTERS = "com.squareup.moshi:moshi-adapters:${Vers.moshiVersion}"
    const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:${Vers.moshiVersion}"
    const val PICASSO = "com.squareup.picasso:picasso:${Vers.picassoVersion}"

    const val HILT = "com.google.dagger:hilt-android:${Vers.hiltVersion}"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Vers.hiltVersion}"
    const val HILTX_COMPILER = "androidx.hilt:hilt-compiler:1.0.0-alpha01"

    const val NAV_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Vers.navigationVersion}"
    const val NAV_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Vers.navigationVersion}"
    const val NAV_DYNAMIC_FEATURES =
        "androidx.navigation:navigation-dynamic-features-fragment:${Vers.navigationVersion}"
    const val NAV_TESTING = "androidx.navigation:navigation-testing:${Vers.navigationVersion}"
    const val JUNIT = "junit:junit:${Vers.junitVersion}"
    const val MOCKITO_CORE = "org.mockito:mockito-core:${Vers.mockitoCoreVersion}"
    const val CORE_TESTING = "android.arch.core:core-testing:${Vers.coreTestingVersion}"
    const val MOCKITO_INLINE = "org.mockito:mockito-inline:${Vers.mockitoInlineVersion}"
    const val KOTLINX_COROUTINE_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Vers.kotlinxCourotineTestVersion}"
    const val TEST_RUNNER = "androidx.test:runner:${Vers.testRunnerVersion}"
    const val ANDROID_TEST_JUNIT = "androidx.test.ext:junit:${Vers.androidTestJunitVersion}"
    const val JUNIT_KTX = "androidx.test.ext:junit-ktx:${Vers.junitKtxVersion}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Vers.espressoVersion}"
    const val ESPRESSO_IDLING_RESOURCE =
        "androidx.test.espresso:espresso-idling-resource:${Vers.espressoVersion}"
    const val JW_IDLING_RESOURCE =
        "com.jakewharton.espresso:okhttp3-idling-resource:${Vers.jwIdlingResourceVersion}"
}

object AppConfig {
    const val APP_NAME = "com.myke.sharecare.githubusers"
    const val COMPILE_SDK_VERSION = 31
    const val MIN_SDK_VERSION = 21
    const val TARGER_SDK_VERSION = 31
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
}