package com.myke.sharecare.feature.details

import com.myke.sharecare.feature.details.data.GithubUserDetailsRepository
import com.myke.sharecare.feature.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.feature.details.data.source.remote.GithubUserDetailsRemoteDatasource
import com.myke.sharecare.githubusers.utils.BaseUnitTest
import com.myke.sharecare.shared.result.DataState
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GithubUserDetailsRepositoryTest : BaseUnitTest() {

    lateinit var repository: GithubUserDetailsRepository
    private val datasource: GithubUserDetailsRemoteDatasource = mock()
    private val user = mock<GithubUserDetailsRaw>()
    private val expected = DataState.Success(user)
    private val exception = Exception("")

    private val username = "mojombo"

    @Test
    fun `should call datasource when request user details`() = runTest {
        mockSuccessfulCase()
        repository.getUserDetails(username)

        verify(datasource, times(1)).getGithubUserDetails(username)
    }


    @Test
    fun `should get success result when fetch user details`() = runTest {
        mockSuccessfulCase()

        assertEquals(expected, repository.getUserDetails(username))
    }

    @Test
    fun `should get failure result when fetch user details`() = runTest {
        mockFailureCase()

        assertEquals(exception, repository.getUserDetails(username))
    }

    private suspend fun mockSuccessfulCase() {
        whenever(datasource.getGithubUserDetails(username)).thenReturn(
            expected
        )

        repository = GithubUserDetailsRepository(datasource)
    }

    private suspend fun mockFailureCase() {
        whenever(datasource.getGithubUserDetails(username)).thenReturn(
            DataState.Error(exception)
        )

        repository = GithubUserDetailsRepository(datasource)
    }


}