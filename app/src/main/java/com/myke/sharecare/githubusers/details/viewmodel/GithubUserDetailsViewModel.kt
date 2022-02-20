package com.myke.sharecare.githubusers.details.viewmodel

import androidx.lifecycle.*
import com.myke.sharecare.githubusers.details.data.model.GithubUserDetails
import com.myke.sharecare.githubusers.details.data.GithubUserDetailsRepository
import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.githubusers.details.interactors.GetGithubUserDetailsUseCase
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.shared.utils.Resource
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class GithubUserDetailsViewModel @Inject constructor(private val usecase: GetGithubUserDetailsUseCase) :
    ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val loader = MutableLiveData<Boolean>()


    private val _userDetails = MutableLiveData<Resource<GithubUserDetails>>()
    val userDetails: LiveData<Resource<GithubUserDetails>>
        get() = _userDetails


    fun getUserDetails(username: String) {
//        wrapEspressoIdlingResource {
        viewModelScope.launch {
            _userDetails.postValue(Resource.loading(null))
            loader.postValue(true)
//                if (networkHelper?.isNetworkConnected() == true) {
            usecase.run(username).let {
//                if (it.isSuccessful) {
//                    it.body()?.let { results ->
//                                Log.i(TAG, "Successfully Retrieved ${results.totalResults} movies")
                _userDetails.postValue(Resource.success(it))
            }
//                } else {
////                            Log.e(
////                                TAG,
////                                "Error fetching online movie records: ${it.errorBody().toString()} "
////                            )
//                    _userDetails.postValue(Resource.error(it.errorBody().toString(), null))
//                }
        }
//                }
    }
//        }
}
