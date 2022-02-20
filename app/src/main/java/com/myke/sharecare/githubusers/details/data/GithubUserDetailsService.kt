package com.myke.sharecare.githubusers.details.data

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetails
import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.githubusers.details.data.source.remote.GithubUserDetailsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException
import javax.inject.Inject

class GithubUserDetailsService @Inject constructor(private val api: GithubUserDetailsApi) {

//    suspend fun fetchUserDetails(id: String): Flow<Result<GithubUserDetailsRaw>> = flow {
//        emit(Result.success(api.fetchUserDetails(id)))
//    }.catch {
//        emit(Result.failure(RuntimeException("something went wrong")))
//    }
}
