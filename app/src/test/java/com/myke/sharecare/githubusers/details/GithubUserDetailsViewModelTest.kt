package com.myke.sharecare.githubusers.details

import com.myke.sharecare.githubusers.details.data.model.GithubUserDetails
import com.myke.sharecare.githubusers.details.interactors.GetGithubUserDetailsUseCase
import com.myke.sharecare.githubusers.details.viewmodel.GithubUserDetailsViewModel
import com.myke.sharecare.githubusers.utils.BaseUnitTest
import com.myke.sharecare.githubusers.utils.captureValues
import com.myke.sharecare.githubusers.utils.getValueForTest
import com.myke.sharecare.shared.result.DataState
import com.myke.sharecare.shared.result.exception
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GithubUserDetailsViewModelTest : BaseUnitTest() {


    private lateinit var viewModel: GithubUserDetailsViewModel
    private val usecase: GetGithubUserDetailsUseCase = mock()
    private val user = mock<GithubUserDetails>()
    private val expected = DataState.Success(user)
    private val exception = Exception()

    private val username = "mojombo"

    @Test
    fun `should get user details from usecase`() = runTest {
        mockSuccessfulCase()

        viewModel.getUserDetails(username)
        viewModel.userDetails.getValueForTest()

        verify(usecase, times(1)).run(username)
    }

    @Test
    fun `should provide success result of user details from usecase`() = runTest {
        mockSuccessfulCase()

        viewModel.getUserDetails(username)
        assertEquals(expected, viewModel.userDetails.getValueForTest())
    }

    @Test
    fun `should return error from usecase when fails`() {
        mockFailureCase()

        assertEquals(exception, viewModel.userDetails.getValueForTest()?.exception)
    }

    @Test
    fun `should show loader whilst loading user details`() = runTest {
        mockSuccessfulCase()
        viewModel.loader.captureValues {

            viewModel.getUserDetails(username)

            viewModel.userDetails.getValueForTest()

            assertEquals(true, values[0])
        }
    }

    @Test
    fun `should close loader after user details load`() {
        mockSuccessfulCase()

        viewModel.loader.captureValues {

            viewModel.getUserDetails(username)

            viewModel.userDetails.getValueForTest()

            assertEquals(false, values.last())
        }
    }


    private fun mockSuccessfulCase() = runTest {
        whenever(usecase.run(username)).thenReturn(
            expected
        )

        viewModel = GithubUserDetailsViewModel(usecase)

    }

    private fun mockFailureCase() {
        runTest {
            whenever(usecase.run(username)).thenReturn(
                DataState.Error(exception)
            )
        }

        viewModel = GithubUserDetailsViewModel(usecase)

        viewModel.getUserDetails(username)
    }
}