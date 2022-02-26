package com.myke.sharecare.feature.details.data.source

import com.myke.sharecare.shared.data.entities.GithubUserDetailsRaw
import com.myke.sharecare.shared.data.result.DataState

interface GithubUserDetailsDatasource {
    suspend fun getGithubUserDetails(username: String): DataState<GithubUserDetailsRaw>
}