package com.myke.sharecare.feature.user.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.myke.sharecare.feature.user.data.GithubUserRepository.Companion.NETWORK_PAGE_SIZE
import com.myke.sharecare.feature.user.data.source.local.GithubUsersLocalDatasource
import com.myke.sharecare.feature.user.data.source.remote.GithubUsersRemoteDatasource
import com.myke.sharecare.shared.data.entities.GithubUserRaw
import com.myke.sharecare.shared.data.result.data
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class GithubUsersRemoteMediator(
    private val service: GithubUsersRemoteDatasource,
    private val database: GithubUsersLocalDatasource
) : RemoteMediator<Int, GithubUserRaw>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GithubUserRaw>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null

                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = true
                        )

                    lastItem.id
                }
            }

            val response = service.fetchGithubUsers(0, NETWORK_PAGE_SIZE)
            database.insertAll(response.data)

            MediatorResult.Success(
                endOfPaginationReached =  response.data?.isEmpty() ?: true
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

}