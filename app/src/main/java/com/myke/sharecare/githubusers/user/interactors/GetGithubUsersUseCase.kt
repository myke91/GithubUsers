package com.myke.sharecare.githubusers.user.interactors

import androidx.paging.PagingData
import androidx.paging.map
import com.myke.sharecare.browsr.base.usecasetypes.BaseUseCaseWithOutParams
import com.myke.sharecare.githubusers.user.data.GithubUserRepository
import com.myke.sharecare.githubusers.user.data.model.GithubUser
import com.myke.sharecare.shared.usecasetypes.BaseUseCaseWithParams
import io.reactivex.Flowable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetGithubUsersUseCase @Inject constructor(private val repository: GithubUserRepository) :
    BaseUseCaseWithOutParams<Flowable<PagingData<GithubUser>>> {

    override suspend fun run(): Flowable<PagingData<GithubUser>> {
        return repository.getGithubUsers().map{ userRaw ->
            userRaw.map {
                GithubUser(user = it.login, it.avatarUrl, it.url)
            }
        }

    }
}