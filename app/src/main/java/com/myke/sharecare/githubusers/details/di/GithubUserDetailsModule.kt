package com.myke.sharecare.githubusers.details.di

import com.myke.sharecare.githubusers.details.data.GithubUserDetailsRepository
import com.myke.sharecare.githubusers.details.data.source.GithubUserDetailsDatasource
import com.myke.sharecare.githubusers.details.data.source.remote.GithubUserDetailsApi
import com.myke.sharecare.githubusers.details.data.source.remote.GithubUserDetailsRemoteDatasource
import com.myke.sharecare.githubusers.details.interactors.GetGithubUserDetailsUseCase
import com.myke.sharecare.githubusers.user.business.GithubUserMapper
import com.myke.sharecare.githubusers.user.data.GithubUserRepository
import com.myke.sharecare.githubusers.user.data.source.GithubUserDatasource
import com.myke.sharecare.githubusers.user.data.source.remote.GithubUserApi
import com.myke.sharecare.githubusers.user.data.source.remote.GithubUsersRemoteDatasource
import com.myke.sharecare.githubusers.user.interactors.GetGithubUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import retrofit2.Retrofit

@Module
@InstallIn(FragmentComponent::class)
class GithubUserDetailsModule {

    @Provides
    fun githubUserDetailsAPI(retrofit: Retrofit): GithubUserDetailsApi = retrofit.create(
        GithubUserDetailsApi::class.java)


    @Provides
    fun getGithubUserDetailsUseCase(repository: GithubUserDetailsRepository) = GetGithubUserDetailsUseCase(repository)


    @Provides
    fun githubUserDetailsRepository(
        datasource: GithubUserDetailsDatasource
    ): GithubUserDetailsRepository = GithubUserDetailsRepository(datasource)

    @Provides
    fun githubUserDetailsDatasource(api: GithubUserDetailsApi): GithubUserDetailsDatasource =
        GithubUserDetailsRemoteDatasource(api)

}