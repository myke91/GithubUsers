package com.myke.sharecare.githubusers.details.data.source.remote

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.githubusers.details.data.source.GithubUserDetailsDatasource
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.githubusers.user.data.source.GithubUserDatasource
import retrofit2.Response
import javax.inject.Inject

class GithubUserDetailsRemoteDatasource @Inject constructor(val api: GithubUserDetailsApi) :
    GithubUserDetailsDatasource {

    override suspend fun getGithubUserDetails(username: String): Response<GithubUserDetailsRaw> =
        api.fetchUserDetails(username)

}