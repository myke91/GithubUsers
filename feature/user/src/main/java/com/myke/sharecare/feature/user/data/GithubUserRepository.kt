package com.myke.sharecare.feature.user.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.myke.sharecare.feature.user.data.paging.GithubUsersPagingSource
import com.myke.sharecare.shared.data.entities.GithubUserRaw
import com.myke.sharecare.feature.user.data.source.local.GithubUsersLocalDatasource
import com.myke.sharecare.feature.user.data.source.remote.GithubUsersRemoteDatasource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class GithubUserRepository @Inject constructor(
    private val remoteDatasource: GithubUsersRemoteDatasource,
    private val localDatasource: GithubUsersLocalDatasource
) {
    fun getGithubUsers(): Flow<PagingData<GithubUserRaw>> {
        val loadResult = GithubUsersPagingSource(remoteDatasource)


        //check loadreuslt

        //get error or success

        // return error or success



        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                loadResult
            }
        ).flow


    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }


}
