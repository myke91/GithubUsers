package com.myke.sharecare.githubusers.user.data.source.remote

import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.githubusers.user.data.source.GithubUserDatasource
import retrofit2.Response
import javax.inject.Inject

class GithubUsersRemoteDatasource @Inject constructor(val api: GithubUserApi) :
    GithubUserDatasource {

    override suspend fun fetchGithubUsers(position :Int?, perPage: Int?): Response<List<GithubUserRaw>> =
        api.fetchAllUsers(position, perPage)

}