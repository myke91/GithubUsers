package com.myke.sharecare.githubusers.user.data.source

import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response

interface GithubUserDatasource {
    fun fetchGithubUsers(position: Int?, perPage: Int?): Single<List<GithubUserRaw>>
}