package com.myke.sharecare.githubusers.details.interactors

import com.myke.sharecare.githubusers.details.data.GithubUserDetailsRepository
import com.myke.sharecare.githubusers.details.data.model.GithubUserDetails
import com.myke.sharecare.shared.usecasetypes.BaseUseCaseWithParams
import java.lang.Exception
import javax.inject.Inject

class GetGithubUserDetailsUseCase @Inject constructor(private val repository: GithubUserDetailsRepository) :
    BaseUseCaseWithParams<String, GithubUserDetails> {
    override suspend fun run(username: String): GithubUserDetails {
        val response = repository.getUserDetails(username)
        if (response.isSuccessful) {
            response.body()?.let {
                return GithubUserDetails(
                    it.avatarUrl,
                    it.login,
                    it.htmlUrl,
                    it.name,
                    it.twitterUsername ?: "",
                    it.company?: "",
                    it.location?: "",
                    it.blog?: "",
                    it.email?: ""
                )
            }
        }
        throw Exception("something went wrong")

    }


}