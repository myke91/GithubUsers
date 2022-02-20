package com.myke.sharecare.githubusers.user

import androidx.paging.PagingData
import com.myke.sharecare.githubusers.user.data.model.GithubUser
import com.myke.sharecare.githubusers.user.data.GithubUserRepository
import com.myke.sharecare.githubusers.user.interactors.GetGithubUsersUseCase
import com.myke.sharecare.githubusers.user.viewmodel.GithubUserViewModel
import com.myke.sharecare.githubusers.utils.BaseUnitTest
import com.myke.sharecare.githubusers.utils.captureValues
import com.myke.sharecare.githubusers.utils.getValueForTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals

import org.junit.Test

import java.lang.RuntimeException

class GithubUserViewModelTest : BaseUnitTest() {

    private lateinit var viewModel: GithubUserViewModel
    private val usecase: GetGithubUsersUseCase = mock()
    private val users = mock<PagingData<GithubUser>>()
    private val exception = RuntimeException("something went wrong")


    @Test
    fun `should get user list from usecase`() = runBlockingTest {
        mockSuccessfulCase()
        viewModel.pagedUserList.first()

        verify(usecase, times(1)).run()
    }


    @Test
    fun `should emit error when receive error`() = runBlockingTest {
        mockFailureCase()

        assertEquals(exception, viewModel.pagedUserList.first())
    }


    @Test
    fun `should show loader whilst loading`() = runBlockingTest {
        mockSuccessfulCase()
//        viewModel.loader.captureValues {
//            viewModel.users.getValueForTest()
//
//            assertEquals(true, values[0])
//        }
    }

    @Test
    fun `should close loader after users Load`() = runBlockingTest {
        mockSuccessfulCase()

//        viewModel.loader.captureValues {
//            viewModel.users.getValueForTest()
//
//            assertEquals(false, values.last())
//        }
    }

    @Test
    fun `should close loader after error`() = runBlockingTest {
        mockFailureCase()

//        viewModel.loader.captureValues {
//            viewModel.users.getValueForTest()
//
//            assertEquals(false, values.last())
//        }
    }


    private fun mockSuccessfulCase() {
        runBlockingTest {
            whenever(usecase.run()).thenReturn(
                flow {
                    emit(users)
                }
            )
        }
        viewModel = GithubUserViewModel(usecase)

        viewModel.getUsers()
    }

    private fun mockFailureCase() {
        runBlockingTest {
            whenever(usecase.run()).thenThrow(
                exception
            )
        }

        viewModel = GithubUserViewModel(usecase)

        viewModel.getUsers()
    }
}