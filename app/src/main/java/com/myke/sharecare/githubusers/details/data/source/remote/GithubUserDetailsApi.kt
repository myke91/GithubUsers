package com.myke.sharecare.githubusers.details.data.source.remote

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetails
import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubUserDetailsApi {

    @GET("users/{username}")
    suspend fun fetchUserDetails(@Path("username") username: String): Response<GithubUserDetailsRaw>
}
