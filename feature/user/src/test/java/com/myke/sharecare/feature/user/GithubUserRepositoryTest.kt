package com.myke.sharecare.feature.user

import androidx.paging.PagingData
import com.myke.sharecare.feature.user.business.GithubUserMapper
import com.myke.sharecare.shared.data.entities.GithubUser
import com.myke.sharecare.shared.data.entities.GithubUserRaw
import com.myke.sharecare.feature.user.data.GithubUserRepository
import com.myke.sharecare.feature.user.data.paging.GithubUsersPagingSource
import com.myke.sharecare.feature.user.data.source.local.GithubUsersLocalDatasource
import com.myke.sharecare.feature.user.data.source.remote.GithubUsersRemoteDatasource
import com.myke.sharecare.shared.utils.BaseUnitTest
import com.myke.sharecare.shared.data.result.DataState
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import retrofit2.Response
import java.lang.RuntimeException

class GithubUserRepositoryTest : BaseUnitTest() {

    private lateinit var repository: GithubUserRepository
    private val remoteDatasource: GithubUsersRemoteDatasource = mock()
    private val localDatasource: GithubUsersLocalDatasource = mock()
    private val pagingSource: GithubUsersPagingSource = mock()
    private val pagedUsers = mock<PagingData<List<GithubUser>>>()
    private val users = mock<List<GithubUserRaw>>()
    private val exception = RuntimeException("something went wrong")
    private val usersRawResponse = mock<Response<List<GithubUserRaw>>>()
    private val usersRawPagingData = mock<PagingData<List<GithubUserRaw>>>()
    private val mapper: GithubUserMapper = mock()

    @Test
    fun `should get github users from paging source`() = runTest {
        mockSuccessfulCase()

        repository.getGithubUsers()

        verify(pagingSource, times(1))
    }

    @Test
    fun `should emit paging data from paging source`() = runTest {
        mockSuccessfulCase()

        assertEquals(usersRawPagingData, repository.getGithubUsers().first())
    }



    @Test
    fun `should propagate errors`() = runTest {
       mockFailureCase()

        assertEquals(exception, repository.getGithubUsers().first())
    }

    private suspend fun mockSuccessfulCase() {
        whenever(remoteDatasource.fetchGithubUsers(0, 20)).thenReturn(
            DataState.Success(users)
        )

        whenever(repository.getGithubUsers()).thenReturn(
            flow {
                usersRawPagingData
            }
        )


        repository = GithubUserRepository(remoteDatasource, localDatasource)
    }

    private suspend fun mockFailureCase() {
        whenever(remoteDatasource.fetchGithubUsers(0,20)).thenThrow(
           exception
        )

        repository = GithubUserRepository(remoteDatasource, localDatasource)
    }
}