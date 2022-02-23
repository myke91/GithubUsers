package com.myke.sharecare.githubusers.details.data.source

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.shared.result.DataState

interface GithubUserDetailsDatasource {
    suspend fun getGithubUserDetails(username: String): DataState<GithubUserDetailsRaw>
}