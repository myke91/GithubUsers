package com.myke.sharecare.feature.user.business

import com.myke.sharecare.shared.data.entities.GithubUser
import com.myke.sharecare.shared.data.entities.GithubUserRaw


class GithubUserMapper : Function1<List<GithubUserRaw>, List<GithubUser>> {

    override fun invoke(githubUserRaw: List<GithubUserRaw>): List<GithubUser> {
        return githubUserRaw.map {
            GithubUser(it.login, it.avatarUrl, it.url)
        }
    }

}
