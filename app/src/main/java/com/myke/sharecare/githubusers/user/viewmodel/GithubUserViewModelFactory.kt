package com.myke.sharecare.githubusers.user.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myke.sharecare.githubusers.user.business.GithubUserMapper
import com.myke.sharecare.githubusers.user.data.GithubUserRepository
import com.myke.sharecare.githubusers.user.data.source.remote.GithubUsersRemoteDatasource
import com.myke.sharecare.githubusers.user.interactors.GetGithubUsersUseCase
import javax.inject.Inject

class GithubUserViewModelFactory @Inject constructor(
    private val usecase: GetGithubUsersUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GithubUserViewModel(usecase) as T
    }

}
