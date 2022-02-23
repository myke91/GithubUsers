package com.myke.sharecare.githubusers.user

import com.myke.sharecare.githubusers.user.data.source.remote.GithubUserApi
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.githubusers.user.data.source.GithubUserDatasource
import com.myke.sharecare.githubusers.user.data.source.remote.GithubUsersRemoteDatasource
import com.myke.sharecare.githubusers.utils.BaseUnitTest
import com.myke.sharecare.shared.result.DataState
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Test
import retrofit2.Response
import java.lang.RuntimeException

class GithubUserRemoteDatasourceTest : BaseUnitTest() {

    private lateinit var datasource: GithubUsersRemoteDatasource
    private val api: GithubUserApi = mock()
    private val users = mock<DataState<List<GithubUserRaw>>>()
    private val usersResponse = mock<Response<List<GithubUserRaw>>>()
    private val exception = RuntimeException("Damn backend developer")

    @Test
    fun `should fetch users from API`() = runTest {
        mockSuccessfulCase()

        datasource.fetchGithubUsers(0, 20)

        verify(api, times(1)).fetchAllUsers()

    }

    @Test
    fun `should convert api response to data state and return them`() = runTest {
        mockSuccessfulCase()

        assertEquals(users, datasource.fetchGithubUsers(0, 20))
    }



    @Test
    fun `should emit error result when network fails`() = runTest {
        mockFailureCase()

//        assertEquals("something went wrong", datasource.fetchUsers().first().exceptionOrNull()?.message)
    }

    private suspend fun mockFailureCase() {
        whenever(api.fetchAllUsers()).thenThrow(exception)

        datasource = GithubUsersRemoteDatasource(api)
    }

    private suspend fun mockSuccessfulCase() = runTest{
        whenever(api.fetchAllUsers()).thenReturn(usersResponse)
        datasource = GithubUsersRemoteDatasource(api)
    }
}