package com.myke.sharecare.feature.user.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myke.sharecare.feature.user.interactors.GetGithubUsersUseCase
import javax.inject.Inject

class GithubUserViewModelFactory @Inject constructor(
    private val usecase: GetGithubUsersUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GithubUserViewModel(usecase) as T
    }

}
