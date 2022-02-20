package com.myke.sharecare.githubusers.details

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetails
import com.myke.sharecare.githubusers.details.viewmodel.GithubUserDetailsViewModel
import com.myke.sharecare.githubusers.user.data.GithubUserRepository
import com.myke.sharecare.githubusers.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.lang.RuntimeException

class GithubUserDetailsViewModelTest : BaseUnitTest() {


    private lateinit var viewModel: GithubUserDetailsViewModel
    private val repository: GithubUserRepository = mock()
    private val playlists = mock<GithubUserDetails>()
    private val expected = Result.success(playlists)
    private val exception = RuntimeException("something went wrong")
    private val service: GithubUserDetailsService = mock()

    private val id = "1"

    @Test
    fun getPlaylistDetailsFromService() = runBlockingTest {
//        mockSuccessfulCase()
//
//        viewModel.getPlaylistsDetails(id)
//        viewModel.userDetails.getValueForTest()
//
//        verify(service, times(1)).fetchUserDetails(id)
    }

    @Test
    fun emitPlaylistDetailsFromService() = runBlockingTest {
//        mockSuccessfulCase()
//
//        viewModel.getPlaylistsDetails(id)
//        assertEquals(expected, viewModel.userDetails.getValueForTest())
    }

    @Test
    fun emitErrorWhenServiceFails() {
//        mockFailureCase()
//
//        assertEquals(exception, viewModel.userDetails.getValueForTest()!!.exceptionOrNull())
    }

    @Test
    fun showLoaderWhilstLoadingPlaylistDetails() = runBlockingTest {
        mockSuccessfulCase()
//        viewModel.loader.captureValues {
//
//            viewModel.getPlaylistsDetails(id)
//
//            viewModel.userDetails.getValueForTest()
//
//            Assert.assertEquals(true, values[0])
//        }
    }

    @Test
    fun closeLoaderAfterPlaylistDetailsLoad() {
        mockSuccessfulCase()

//        viewModel.loader.captureValues {
//
//            viewModel.getPlaylistsDetails(id)
//
//            viewModel.userDetails.getValueForTest()
//
//            Assert.assertEquals(false, values.last())
//        }
    }


    private fun mockSuccessfulCase() = runBlockingTest {
//        whenever(service.fetchUserDetails(id)).thenReturn(
//            flow {
//                emit(expected)
//            }
//        )
//
//        viewModel = GithubUserDetailsViewModel(service)

    }

    private fun mockFailureCase() {
//        runBlockingTest {
//            whenever(service.fetchUserDetails(id)).thenReturn(
//                flow {
//                    emit(Result.failure<GithubUserDetails>(exception))
//                }
//            )
//        }

//        viewModel = GithubUserDetailsViewModel(service)
//
//        viewModel.getPlaylistsDetails(id)
    }
}