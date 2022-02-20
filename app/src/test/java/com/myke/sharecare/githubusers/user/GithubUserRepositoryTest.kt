package com.myke.sharecare.githubusers.user

import androidx.paging.PageKeyedDataSource
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.myke.sharecare.githubusers.user.business.GithubUserMapper
import com.myke.sharecare.githubusers.user.data.model.GithubUser
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.githubusers.user.data.GithubUserRepository
import com.myke.sharecare.githubusers.user.data.source.GithubUserDatasource
import com.myke.sharecare.githubusers.user.data.source.remote.GithubPagingSource
import com.myke.sharecare.githubusers.user.data.source.remote.GithubUsersRemoteDatasource
import com.myke.sharecare.githubusers.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import retrofit2.Response
import java.lang.RuntimeException

class GithubUserRepositoryTest : BaseUnitTest() {

    private lateinit var repository: GithubUserRepository
    private val datasource: GithubUsersRemoteDatasource = mock()
    private val pagingSource: GithubPagingSource = mock()
    private val users = mock<PagingData<List<GithubUser>>>()
    private val exception = RuntimeException("something went wrong")
    private val usersRawResponse = mock<Response<List<GithubUserRaw>>>()
    private val usersRawPagingData = mock<PagingData<List<GithubUserRaw>>>()
    private val mapper: GithubUserMapper = mock()

    @Test
    fun getGithubUsersFromPagingSource() = runBlockingTest {
        mockSuccessfulCase()

        repository.getGithubUsers()

        verify(pagingSource, times(1))
    }

    @Test
    fun emitPagingDataFromPagingSource() = runBlockingTest {
        mockSuccessfulCase()

        assertEquals(usersRawPagingData, repository.getGithubUsers().first())
    }



    @Test
    fun propagateErrors() = runBlockingTest {
       mockFailureCase()

        assertEquals(exception, repository.getGithubUsers().first())
    }

    private suspend fun mockSuccessfulCase() {
        whenever(datasource.fetchGithubUsers(0, 20)).thenReturn(
            usersRawResponse
        )

        whenever(repository.getGithubUsers()).thenReturn(
            flow {
                usersRawPagingData
            }
        )


        repository = GithubUserRepository(datasource)
    }

    private suspend fun mockFailureCase() {
        whenever(datasource.fetchGithubUsers(0,20)).thenThrow(
           exception
        )

        repository = GithubUserRepository(datasource)
    }
}