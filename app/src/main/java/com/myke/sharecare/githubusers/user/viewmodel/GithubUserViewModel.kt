package com.myke.sharecare.githubusers.user.viewmodel

import androidx.lifecycle.*
import androidx.paging.*
import com.myke.sharecare.githubusers.user.data.model.GithubUser
import com.myke.sharecare.githubusers.user.interactors.GetGithubUsersUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class GithubUserViewModel @Inject constructor(
    private val useCase: GetGithubUsersUseCase,
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val loader = MutableLiveData<Boolean>()
    val currentView = MutableLiveData<ViewType>()

    lateinit var pagedUserList: Flow<PagingData<GithubUser>>

    fun getUsers() {
        loader.postValue(true)
        viewModelScope.launch {
            useCase.run().let {
                pagedUserList = it
                loader.postValue(false)
            }
        }
    }

    fun switchView(viewType: ViewType) {
        currentView.value = viewType
    }

}
