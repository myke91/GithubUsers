package com.myke.sharecare.feature.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myke.sharecare.feature.details.interactors.GetGithubUserDetailsUseCase
import javax.inject.Inject

class GithubUserDetailsViewModelFactory @Inject constructor(private val usecase: GetGithubUserDetailsUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GithubUserDetailsViewModel(usecase) as T
    }
}
