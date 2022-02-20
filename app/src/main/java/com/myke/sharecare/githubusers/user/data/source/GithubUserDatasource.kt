package com.myke.sharecare.githubusers.user.data.source

import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import retrofit2.Response

interface GithubUserDatasource {
    suspend fun fetchGithubUsers(position: Int?, perPage: Int?): Response<List<GithubUserRaw>>
}