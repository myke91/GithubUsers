package com.myke.sharecare.githubusers.user.data.source.remote

import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubUserApi {

    @GET("users")
    fun fetchAllUsers(
        @Query("since") page: Int? = 0,
        @Query("per_page") perPage: Int? = 20
    ): Single<List<GithubUserRaw>>
}
