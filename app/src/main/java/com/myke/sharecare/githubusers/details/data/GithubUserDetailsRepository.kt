package com.myke.sharecare.githubusers.details.data

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetails
import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.githubusers.details.data.source.GithubUserDetailsDatasource
import com.myke.sharecare.githubusers.user.business.GithubUserMapper
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.githubusers.user.data.source.GithubUserDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

class GithubUserDetailsRepository @Inject constructor(
    private val datasource: GithubUserDetailsDatasource,
    private val mapper: GithubUserMapper
) {

    suspend fun getUserDetails(username: String): Response<GithubUserDetailsRaw> = datasource.getGithubUserDetails(username)

}
