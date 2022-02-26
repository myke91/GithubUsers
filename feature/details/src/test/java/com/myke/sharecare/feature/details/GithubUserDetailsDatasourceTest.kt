package com.myke.sharecare.feature.details

import com.myke.sharecare.shared.data.entities.GithubUserDetailsRaw
import com.myke.sharecare.feature.details.data.source.remote.GithubUserDetailsApi
import com.myke.sharecare.feature.details.data.source.remote.GithubUserDetailsRemoteDatasource
import com.myke.sharecare.shared.data.result.DataState
import com.myke.sharecare.shared.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import retrofit2.Response

class GithubUserDetailsDatasourceTest : BaseUnitTest() {

    lateinit var datasource: GithubUserDetailsRemoteDatasource
    private val api: GithubUserDetailsApi = mock()
    private val user = mock<GithubUserDetailsRaw>()
    private val expectedResponse: Response<GithubUserDetailsRaw> = mock()
    private val expected: DataState<GithubUserDetailsRaw> = mock()
    private val exception = Exception("")

    private val username = "mojombo"

    //call api

    @Test
    fun `should call api when fetch user details`() = runTest {
        mockSuccessfulCase()
        datasource.getGithubUserDetails(username)

        verify(api, times(1)).fetchUserDetails(username)
    }


    @Test
    fun `should get success result when fetch user details`() = runTest {
        mockSuccessfulCase()

        assertEquals(expected, datasource.getGithubUserDetails(username))
    }

    @Test
    fun `should get failure result when fetch user details`() = runTest {
        mockFailureCase()

        assertEquals(exception, datasource.getGithubUserDetails(username))
    }

    private suspend fun mockSuccessfulCase() {
        whenever(api.fetchUserDetails(username)).thenReturn(expectedResponse)

        datasource = GithubUserDetailsRemoteDatasource(api)
    }

    private suspend fun mockFailureCase() {
        whenever(api.fetchUserDetails(username)).thenThrow(exception)

        datasource = GithubUserDetailsRemoteDatasource(api)
    }

}