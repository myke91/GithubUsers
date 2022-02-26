package com.myke.sharecare.feature.user.di

import com.jakewharton.espresso.OkHttp3IdlingResource
import com.myke.sharecare.feature.user.BuildConfig
import com.myke.sharecare.feature.user.business.GithubUserMapper
import com.myke.sharecare.feature.user.data.GithubUserRepository
import com.myke.sharecare.feature.user.data.source.GithubUserDatasource
import com.myke.sharecare.feature.user.data.source.local.GithubUsersLocalDatasource
import com.myke.sharecare.feature.user.data.source.remote.GithubUserApi
import com.myke.sharecare.feature.user.data.source.remote.GithubUsersRemoteDatasource
import com.myke.sharecare.feature.user.interactors.GetGithubUsersUseCase
import com.myke.sharecare.shared.database.GithubUserDao
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit


lateinit var idlingResource: OkHttp3IdlingResource

@Module
@InstallIn(FragmentComponent::class)
class GithubUserModule {

    @Provides
    fun githubUserAPI(retrofit: Retrofit): GithubUserApi =
        retrofit.create(GithubUserApi::class.java)

    @Provides
    fun retrofit(client: OkHttpClient, moshi: Moshi): Retrofit {
        idlingResource = OkHttp3IdlingResource.create("okhttp", client)


        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun moshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    @Provides
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val githubAuthInterceptor = Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader(
                "Authorization",
                Credentials.basic(
                    BuildConfig.GITHUB_CLIENT_ID,
                    BuildConfig.GITHUB_CLIENT_SECRET
                )
            )
            chain.proceed(requestBuilder.build())
        }


        val okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(githubAuthInterceptor)
            .readTimeout(90, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)


        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(httpLoggingInterceptor)
        }

        return okHttpClient.build()

    }


    @Provides
    fun githubUserMapper() = GithubUserMapper()

    @Provides
    fun getGithubUsersUseCase(repository: GithubUserRepository) = GetGithubUsersUseCase(repository)


    @Provides
    fun githubUsersRepository(
        service: GithubUsersRemoteDatasource,
        database: GithubUsersLocalDatasource
    ): GithubUserRepository = GithubUserRepository(service, database)

    @Provides
    fun githubUsersRemoteDatasource(api: GithubUserApi): GithubUsersRemoteDatasource =
        GithubUsersRemoteDatasource(api)

    @Provides
    fun githubUsersLocalDatasource(usersDao: GithubUserDao): GithubUsersLocalDatasource =
        GithubUsersLocalDatasource(usersDao)



    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.tag("SHARECARE - GithubAPI").i(message)
            }
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

}