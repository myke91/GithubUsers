package com.myke.sharecare.githubusers.details.data.source

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import retrofit2.Response

interface GithubUserDetailsDatasource {
    suspend fun getGithubUserDetails(username: String): Response<GithubUserDetailsRaw>
}