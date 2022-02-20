package com.myke.sharecare.githubusers.user.viewmodel

import androidx.lifecycle.*
import androidx.paging.*
import androidx.paging.rxjava2.cachedIn
import com.myke.sharecare.githubusers.user.data.model.GithubUser
import com.myke.sharecare.githubusers.user.interactors.GetGithubUsersUseCase
import io.reactivex.Flowable
import kotlinx.coroutines.launch
import javax.inject.Inject


class GithubUserViewModel @Inject constructor(
    private val useCase: GetGithubUsersUseCase,
) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val loader = MutableLiveData<Boolean>()
    val currentView = MutableLiveData<ViewType>()

    lateinit var pagedUserList: Flowable<PagingData<GithubUser>>

    fun getUsers() {
        loader.postValue(true)
        viewModelScope.launch {
            useCase.run().let {
                pagedUserList = it
                pagedUserList.cachedIn(viewModelScope)
                loader.postValue(false)
            }
        }
    }

    fun switchView(viewType: ViewType) {
        currentView.value = viewType
    }

}
