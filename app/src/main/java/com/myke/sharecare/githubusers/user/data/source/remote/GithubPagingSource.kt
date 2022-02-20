package com.myke.sharecare.githubusers.user.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.myke.sharecare.githubusers.user.data.GithubUserRepository.Companion.NETWORK_PAGE_SIZE
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import retrofit2.HttpException
import java.io.IOException

private const val GITHUB_STARTING_PAGE_INDEX = 0

class GithubPagingSource(
    private val datasource: GithubUsersRemoteDatasource
) : PagingSource<Int, GithubUserRaw>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubUserRaw> {
        val position = params.key ?: GITHUB_STARTING_PAGE_INDEX


        return try {
            val response = datasource.fetchGithubUsers(position, params.loadSize)
            val responseList = mutableListOf<GithubUserRaw>()
            val githubUsers = response.body() ?: emptyList()
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
