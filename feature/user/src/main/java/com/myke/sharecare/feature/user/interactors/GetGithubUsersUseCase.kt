package com.myke.sharecare.feature.user.interactors

import androidx.paging.PagingData
import androidx.paging.map
import com.myke.sharecare.browsr.base.usecasetypes.BaseUseCaseWithOutParams
import com.myke.sharecare.feature.user.data.GithubUserRepository
import com.myke.sharecare.feature.user.data.model.GithubUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetGithubUsersUseCase @Inject constructor(private val repository: GithubUserRepository) :
    BaseUseCaseWithOutParams<Flow<PagingData<GithubUser>>> {

    override suspend fun run(): Flow<PagingData<GithubUser>> {
        return repository.getGithubUsers().map { userRaw ->
            userRaw.map {
                GithubUser(user = it.login, it.avatarUrl, it.url)
            }
        }

    }
}