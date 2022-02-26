package com.myke.sharecare.feature.user.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.myke.sharecare.shared.data.entities.GithubUserRaw
import com.myke.sharecare.feature.user.data.source.GithubUserDatasource
import com.myke.sharecare.feature.user.data.source.local.GithubUsersLocalDatasource
import com.myke.sharecare.feature.user.data.source.remote.GithubPagingSource
import com.myke.sharecare.feature.user.data.source.remote.GithubUsersRemoteDatasource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GithubUserRepository @Inject constructor(
    private val service: GithubUsersRemoteDatasource,
    private val database: GithubUsersLocalDatasource
) {
    fun getGithubUsers(): Flow<PagingData<GithubUserRaw>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GithubPagingSource(service) }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 20
    }


}
