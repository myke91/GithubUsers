package com.myke.sharecare.shared.di

import android.content.Context
import androidx.room.Room
import com.myke.sharecare.shared.BuildConfig
import com.myke.sharecare.shared.database.GithubUsersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideGithubUsersDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            GithubUsersDatabase::class.java,
            BuildConfig.GITHUB_USERS_DATABASE_NAME
        ).build()

    @Provides
    fun provideGithubUsersDao(githubUsersDatabase: GithubUsersDatabase) = githubUsersDatabase.usersDao()
}