package com.myke.sharecare.feature.user.business

import com.myke.sharecare.feature.user.data.model.GithubUser
import com.myke.sharecare.feature.user.data.model.GithubUserRaw


class GithubUserMapper : Function1<List<GithubUserRaw>, List<GithubUser>> {

    override fun invoke(githubUserRaw: List<GithubUserRaw>): List<GithubUser> {
        return githubUserRaw.map {
            GithubUser(it.login, it.avatarUrl, it.url)
        }
    }

}
