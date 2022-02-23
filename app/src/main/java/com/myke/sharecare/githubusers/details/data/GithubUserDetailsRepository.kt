package com.myke.sharecare.githubusers.details.data

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.githubusers.details.data.source.GithubUserDetailsDatasource
import com.myke.sharecare.shared.result.DataState
import javax.inject.Inject

class GithubUserDetailsRepository @Inject constructor(
    private val datasource: GithubUserDetailsDatasource,
) {

    suspend fun getUserDetails(username: String): DataState<GithubUserDetailsRaw> = datasource.getGithubUserDetails(username)

}
