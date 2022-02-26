package com.myke.sharecare.feature.user.data.source

import com.myke.sharecare.shared.data.entities.GithubUserRaw
import com.myke.sharecare.shared.data.result.DataState

interface GithubUserDatasource {
    suspend fun fetchGithubUsers(position: Int?, perPage: Int?): DataState<List<GithubUserRaw>>
}