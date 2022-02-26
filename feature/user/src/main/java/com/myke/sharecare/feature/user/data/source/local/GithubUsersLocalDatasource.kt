package com.myke.sharecare.feature.user.data.source.local

import com.myke.sharecare.feature.user.data.source.GithubUserDatasource
import com.myke.sharecare.shared.data.entities.GithubUser
import com.myke.sharecare.shared.data.entities.GithubUserRaw
import com.myke.sharecare.shared.data.result.DataState
import com.myke.sharecare.shared.database.GithubUserDao
import javax.inject.Inject

class GithubUsersLocalDatasource @Inject constructor(
    private val usersDao: GithubUserDao
) : GithubUserDatasource{

    suspend fun insertAll(users: List<GithubUserRaw>?) {
        usersDao.insertAll(users)
    }

    suspend fun getUserByUsername(username: String) = usersDao.getUserByUsername(username)

    override suspend fun fetchGithubUsers(
        position: Int?,
        perPage: Int?
    ): DataState<List<GithubUserRaw>> {
        TODO("Not yet implemented")
    }
}