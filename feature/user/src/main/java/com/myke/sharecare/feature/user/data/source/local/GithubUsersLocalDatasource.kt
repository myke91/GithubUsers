package com.myke.sharecare.feature.user.data.source.local

import com.myke.sharecare.shared.data.entities.GithubUser
import com.myke.sharecare.shared.database.GithubUserDao
import javax.inject.Inject

class GithubUsersLocalDatasource @Inject constructor(
    private val usersDao: GithubUserDao
) {

    suspend fun insertAll(users: List<GithubUser>) {
        usersDao.insertAll(users)
    }

    suspend fun getUserByUsername(username: String) = usersDao.getUserByUsername(username)
}