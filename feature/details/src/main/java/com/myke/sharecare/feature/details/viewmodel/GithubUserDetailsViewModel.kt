package com.myke.sharecare.feature.details.viewmodel

import androidx.lifecycle.*
import com.myke.sharecare.feature.details.data.model.GithubUserDetails
import com.myke.sharecare.feature.details.interactors.GetGithubUserDetailsUseCase
import com.myke.sharecare.shared.result.DataState
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class GithubUserDetailsViewModel @Inject constructor(private val usecase: GetGithubUserDetailsUseCase) :
    ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val loader = MutableLiveData<Boolean>()


    private val _userDetails = MutableLiveData<DataState<GithubUserDetails>>()
    val userDetails: LiveData<DataState<GithubUserDetails>>
        get() = _userDetails


    fun getUserDetails(username: String) {
        viewModelScope.launch {
            _userDetails.postValue(DataState.Loading)
            loader.postValue(true)
            try {
                usecase.run(username).let {
                    _userDetails.postValue(it)
                }
            }catch (ex: Exception){
                _userDetails.postValue(DataState.Error(ex))
            }
        }
    }
}
