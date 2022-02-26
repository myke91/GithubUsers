package com.myke.sharecare.feature.user.data.source.remote

import com.myke.sharecare.shared.data.entities.GithubUserRaw
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubUserApi {

    @GET("users")
    suspend fun fetchAllUsers(
        @Query("since") page: Int? = 0,
        @Query("per_page") perPage: Int? = 20
    ): Response<List<GithubUserRaw>>
}
