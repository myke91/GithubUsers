package com.myke.sharecare.feature.user.data.source

import com.myke.sharecare.feature.user.data.model.GithubUserRaw
import com.myke.sharecare.shared.result.DataState

interface GithubUserDatasource {
    suspend fun fetchGithubUsers(position: Int?, perPage: Int?): DataState<List<GithubUserRaw>>
}