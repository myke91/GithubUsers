package com.myke.sharecare.githubusers.details.data

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.githubusers.details.data.source.GithubUserDetailsDatasource
import retrofit2.Response
import javax.inject.Inject

class GithubUserDetailsRepository @Inject constructor(
    private val datasource: GithubUserDetailsDatasource,
) {

    suspend fun getUserDetails(username: String): Response<GithubUserDetailsRaw> = datasource.getGithubUserDetails(username)

}
