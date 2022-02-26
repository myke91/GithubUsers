package com.myke.sharecare.feature.user.data.source.remote

import com.myke.sharecare.shared.data.entities.GithubUserRaw
import com.myke.sharecare.feature.user.data.source.GithubUserDatasource
import com.myke.sharecare.shared.data.result.DataState
import com.myke.sharecare.shared.utils.stringSuspending
import javax.inject.Inject

class GithubUsersRemoteDatasource @Inject constructor(val api: GithubUserApi) :
    GithubUserDatasource {

    override suspend fun fetchGithubUsers(
        position: Int?,
        perPage: Int?
    ): DataState<List<GithubUserRaw>> {
        val response = api.fetchAllUsers(position, perPage)

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
