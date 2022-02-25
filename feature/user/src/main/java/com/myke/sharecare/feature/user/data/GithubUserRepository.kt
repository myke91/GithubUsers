package com.myke.sharecare.feature.user.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.myke.sharecare.feature.user.data.model.GithubUserRaw
import com.myke.sharecare.feature.user.data.source.GithubUserDatasource
import com.myke.sharecare.feature.user.data.source.remote.GithubPagingSource
import com.myke.sharecare.feature.user.data.source.remote.GithubUsersRemoteDatasource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GithubUserRepository @Inject constructor(
    private val datasource: GithubUserDatasource
) {
    fun getGithubUsers(): Flow<PagingData<GithubUserRaw>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GithubPagingSource(datasource as GithubUsersRemoteDatasource) }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }


}