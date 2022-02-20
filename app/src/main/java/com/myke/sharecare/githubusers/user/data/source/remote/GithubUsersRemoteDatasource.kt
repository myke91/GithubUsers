package com.myke.sharecare.githubusers.user.data.source.remote

import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.githubusers.user.data.source.GithubUserDatasource
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class GithubUsersRemoteDatasource @Inject constructor(val api: GithubUserApi) :
    GithubUserDatasource {

    override fun fetchGithubUsers(position :Int?, perPage: Int?): Single<List<GithubUserRaw>> =
        api.fetchAllUsers(position, perPage)

}