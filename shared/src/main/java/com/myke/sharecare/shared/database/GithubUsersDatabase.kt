package com.myke.sharecare.shared.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.myke.sharecare.shared.BuildConfig
import com.myke.sharecare.shared.data.entities.GithubUser

@Database(
    entities = [GithubUser::class],
    exportSchema = false,
    version = BuildConfig.GITHUB_USERS_DATABASE_VERSION
)
abstract class GithubUsersDatabase : RoomDatabase() {

    abstract fun usersDao(): GithubUserDao
}