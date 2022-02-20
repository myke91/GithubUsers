package com.myke.sharecare.githubusers.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myke.sharecare.githubusers.details.data.GithubUserDetailsRepository
import com.myke.sharecare.githubusers.details.interactors.GetGithubUserDetailsUseCase
import javax.inject.Inject

class GithubUserDetailsViewModelFactory @Inject constructor(private val usecase: GetGithubUserDetailsUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GithubUserDetailsViewModel(usecase) as T
    }

}
