package com.myke.sharecare.feature.details.data.source.remote

import com.myke.sharecare.feature.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.feature.details.data.source.GithubUserDetailsDatasource
import com.myke.sharecare.shared.result.DataState
import com.myke.sharecare.shared.utils.stringSuspending
import javax.inject.Inject

class GithubUserDetailsRemoteDatasource @Inject constructor(private val api: GithubUserDetailsApi) :
    GithubUserDetailsDatasource {

    override suspend fun getGithubUserDetails(username: String): DataState<GithubUserDetailsRaw> {

        val response = api.fetchUserDetails(username)

        if (response.isSuccessful) {
            response.body()?.let {
                return DataState.Success(it)
            }
        } else {
            val exception = Exception(response.errorBody()?.stringSuspending())
            return DataState.Error(exception)
        }
        return DataState.Error(Exception("something went wrong"))
    }

}