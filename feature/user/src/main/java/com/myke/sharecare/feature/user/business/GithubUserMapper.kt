package com.myke.sharecare.feature.user.business

import androidx.paging.PagingData
import com.myke.sharecare.shared.data.entities.GithubUser
import com.myke.sharecare.shared.data.entities.GithubUserRaw
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GithubUserMapper : Function1<List<GithubUserRaw>, Flow<PagingData<GithubUser>>> {

    override fun invoke(githubUserRaw: List<GithubUserRaw>): Flow<PagingData<GithubUser>> {
        return flow {
            githubUserRaw.map {
                GithubUser(it.login, it.avatarUrl, it.url)
            }
        }
    }

}
