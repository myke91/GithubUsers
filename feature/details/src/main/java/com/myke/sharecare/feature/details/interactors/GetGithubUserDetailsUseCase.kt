package com.myke.sharecare.feature.details.interactors

import com.myke.sharecare.feature.details.data.GithubUserDetailsRepository
import com.myke.sharecare.shared.data.entities.GithubUserDetails
import com.myke.sharecare.shared.data.result.DataState
import com.myke.sharecare.shared.usecasetypes.BaseUseCaseWithParams
import javax.inject.Inject

class GetGithubUserDetailsUseCase @Inject constructor(private val repository: GithubUserDetailsRepository) :
    BaseUseCaseWithParams<String, DataState<GithubUserDetails>> {
    override suspend fun run(params: String): DataState<GithubUserDetails> {
        val response = repository.getUserDetails(params)

        when (response) {
            is DataState.Success -> {
                response.data.let {
                    val mappedUserDetails = GithubUserDetails (
                        it.avatarUrl ?: "",
                        it.login ?: "",
                        it.htmlUrl ?: "",
                        it.name ?: "",
                        it.twitterUsername ?: "",
                        it.company ?: "",
                        it.location ?: "",
                        it.blog ?: "",
                        it.email ?: ""
                    )
                    return DataState.Success(mappedUserDetails)
                }

            }
            is DataState.Error -> {
                return DataState.Error(response.exception)
            }
            else -> {}
        }

        throw IllegalStateException("invalid case")
    }


}