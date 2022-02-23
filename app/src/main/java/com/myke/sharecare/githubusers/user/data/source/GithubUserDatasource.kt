package com.myke.sharecare.githubusers.user.data.source

import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.shared.result.DataState

interface GithubUserDatasource {
    suspend fun fetchGithubUsers(position: Int?, perPage: Int?): DataState<List<GithubUserRaw>>
}