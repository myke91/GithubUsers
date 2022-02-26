package com.myke.sharecare.feature.user.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.myke.sharecare.feature.user.data.GithubUserRepository.Companion.NETWORK_PAGE_SIZE
import com.myke.sharecare.feature.user.data.source.remote.GithubUsersRemoteDatasource
import com.myke.sharecare.shared.data.entities.GithubUserRaw
import com.myke.sharecare.shared.data.result.DataState
import retrofit2.HttpException
import java.io.IOException

private const val GITHUB_STARTING_PAGE_INDEX = 0

class GithubUsersPagingSource(
    private val datasource: GithubUsersRemoteDatasource
) : PagingSource<Int, GithubUserRaw>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubUserRaw> {
        val position = params.key ?: GITHUB_STARTING_PAGE_INDEX

        val response = datasource.fetchGithubUsers(position, params.loadSize)

        return try {
            val responseList = mutableListOf<GithubUserRaw>()
            when (response) {
                is DataState.Success -> {
                    val githubUsers = response.data ?: emptyList()
                    responseList.addAll(githubUsers)

                    val nextKey = if (githubUsers.isEmpty()) {
                        null
                    } else {
                        position + NETWORK_PAGE_SIZE
                    }
                    LoadResult.Page(
                        data = responseList,
                        prevKey = if (position == GITHUB_STARTING_PAGE_INDEX) null else position - NETWORK_PAGE_SIZE,
                        nextKey = nextKey
                    )
                }
                else -> {
                    throw IOException("something went wrong")
                }
            }


        } catch (exception: IOException) {
            return LoadResult.Error(exception)

        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    // The refresh key is used for subsequent refresh calls to PagingSource.load after the initial load
    override fun getRefreshKey(state: PagingState<Int, GithubUserRaw>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }


}
