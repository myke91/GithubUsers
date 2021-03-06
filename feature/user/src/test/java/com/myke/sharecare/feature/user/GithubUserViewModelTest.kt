package com.myke.sharecare.feature.user

import androidx.paging.PagingData
import com.myke.sharecare.shared.data.entities.GithubUser
import com.myke.sharecare.feature.user.interactors.GetGithubUsersUseCase
import com.myke.sharecare.feature.user.viewmodel.GithubUserViewModel
import com.myke.sharecare.feature.user.viewmodel.ViewType
import com.myke.sharecare.shared.utils.BaseUnitTest
import com.myke.sharecare.shared.utils.captureValues
import com.myke.sharecare.shared.utils.getValueForTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals

import org.junit.Test

import java.lang.RuntimeException

class GithubUserViewModelTest : BaseUnitTest() {

    private lateinit var viewModel: GithubUserViewModel
    private val usecase: GetGithubUsersUseCase = mock()
    private val users = mock<PagingData<GithubUser>>()
    private val exception = RuntimeException("something went wrong")


    @Test
    fun `should get user list from usecase`() = runTest {
        mockSuccessfulCase()
        viewModel.pagedUserList.first()

        verify(usecase, times(1)).run()
    }


    @Test
    fun `should emit error when receive error`() = runTest {
        mockFailureCase()

        assertEquals(exception, viewModel.pagedUserList.first())
    }


    @Test
    fun `should show loader whilst loading`() = runTest {
        mockSuccessfulCase()
        viewModel.loader.captureValues {
            viewModel.pagedUserList.first()

            assertEquals(true, values[0])
        }
    }

    @Test
    fun `should close loader after users Load`() = runTest {
        mockSuccessfulCase()

        viewModel.loader.captureValues {
            viewModel.pagedUserList.first()

            assertEquals(false, values.last())
        }
    }

    @Test
    fun `should close loader after error`() = runTest {
        mockFailureCase()

        viewModel.loader.captureValues {
            viewModel.pagedUserList.first()

            assertEquals(false, values.last())
        }
    }

    @Test
    fun `should maintain list type when changed`(){
        mockSuccessfulCase()

        viewModel.currentView.value = ViewType.GRID
        assertEquals(ViewType.GRID, viewModel.currentView.getValueForTest())

        viewModel.currentView.value = ViewType.LIST

        assertEquals(ViewType.LIST, viewModel.currentView.getValueForTest())
    }


    private fun mockSuccessfulCase() {
        runTest {
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
        runTest {
            whenever(usecase.run()).thenThrow(
                exception
            )
        }

        viewModel = GithubUserViewModel(usecase)

        viewModel.getUsers()
    }
}