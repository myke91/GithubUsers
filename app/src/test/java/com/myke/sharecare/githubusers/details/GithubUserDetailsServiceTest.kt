package com.myke.sharecare.githubusers.details

import com.myke.sharecare.githubusers.details.data.source.remote.GithubUserDetailsApi
import com.myke.sharecare.githubusers.details.data.model.GithubUserDetails
import com.myke.sharecare.githubusers.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.lang.RuntimeException

class GithubUserDetailsServiceTest : BaseUnitTest() {

    private lateinit var service: GithubUserDetailsService
    private val api: GithubUserDetailsApi = mock()
    private val userDetails = mock<GithubUserDetails>()
    private val exception = RuntimeException("Damn backend developer")
    private val id = "1"

    @Test
    fun fetchUsersDetailsFromAPI() = runBlockingTest {
//        service = GithubUserDetailsService(api)
//
//        service.fetchUserDetails(id).single()
//
//        verify(api, times(1)).fetchUserDetails(id)
    }

    @Test
    fun convertValuesToFlowResultAndEmitThem() = runBlockingTest {
        mockSuccessfulCase()

//        assertEquals(Result.success(userDetails), service.fetchUserDetails(id).single())
    }


    @Test
    fun emitErrorResultWhenNetworkFails() = runBlockingTest {
        mockFailureCase()

//        assertEquals("something went wrong", service.fetchUserDetails(id).single().exceptionOrNull()?.message)
    }


    private suspend fun mockSuccessfulCase() {
//        whenever(api.fetchUserDetails(id)).thenReturn(userDetails)
//
//        service = GithubUserDetailsService(api)
    }

    private suspend fun mockFailureCase() {
        whenever(api.fetchUserDetails(id)).thenThrow(
            exception
        )

        service = GithubUserDetailsService(api)
    }
}