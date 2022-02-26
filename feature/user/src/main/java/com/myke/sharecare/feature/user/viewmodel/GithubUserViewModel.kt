package com.myke.sharecare.feature.user.viewmodel

import androidx.lifecycle.*
import androidx.paging.*
import com.myke.sharecare.shared.data.entities.GithubUser
import com.myke.sharecare.feature.user.interactors.GetGithubUsersUseCase
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
        viewModelScope.launch {
            loader.postValue(true)
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
