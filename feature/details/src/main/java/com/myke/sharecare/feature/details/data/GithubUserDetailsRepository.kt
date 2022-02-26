package com.myke.sharecare.feature.details.data

import com.myke.sharecare.shared.data.entities.GithubUserDetailsRaw
import com.myke.sharecare.feature.details.data.source.GithubUserDetailsDatasource
import com.myke.sharecare.shared.data.result.DataState
import javax.inject.Inject

class GithubUserDetailsRepository @Inject constructor(
    private val datasource: GithubUserDetailsDatasource,
) {

    suspend fun getUserDetails(username: String): DataState<GithubUserDetailsRaw> = datasource.getGithubUserDetails(username)

}
