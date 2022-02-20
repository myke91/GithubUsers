package com.myke.sharecare.githubusers.user

import com.myke.sharecare.githubusers.user.data.source.remote.GithubUserApi
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.githubusers.user.data.source.GithubUserDatasource
import com.myke.sharecare.githubusers.user.data.source.remote.GithubUsersRemoteDatasource
import com.myke.sharecare.githubusers.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.lang.RuntimeException

class GithubUserRemoteDatasourceTest : BaseUnitTest() {

    private lateinit var datasource: GithubUserDatasource
    private val api: GithubUserApi = mock()
    private val playlists = mock<List<GithubUserRaw>>()
    private val exception = RuntimeException("Damn backend developer")

    @Test
    fun fetchPlaylistFromAPI() = runBlockingTest {
        val datasource = GithubUsersRemoteDatasource(api)

        datasource.fetchGithubUsers(0, 20)

        verify(api, times(1)).fetchAllUsers()

    }

    @Test
    fun convertsValuesToFlowResultAndEmitsThem() = runBlockingTest {
        mockSuccessfulCase()

//        assertEquals(Result.success(playlists), datasource.fetchUsers().first())
    }



    @Test
    fun emitsErrorResultWhenNetworkFails() = runBlockingTest {
        mockFailureCase()

//        assertEquals("something went wrong", datasource.fetchUsers().first().exceptionOrNull()?.message)
    }

    private suspend fun mockFailureCase() {
        whenever(api.fetchAllUsers()).thenThrow(exception)

//        datasource = GithubUserDatasource(api)
    }

    private suspend fun mockSuccessfulCase() {
//        whenever(api.fetchAllUsers()).thenReturn(playlists)
//        datasource = GithubUserDatasource(api)
    }
}