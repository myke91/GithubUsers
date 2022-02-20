package com.myke.sharecare.githubusers.user.data.source.remote

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.myke.sharecare.githubusers.user.data.GithubUserRepository.Companion.NETWORK_PAGE_SIZE
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.io.IOException

private const val GITHUB_STARTING_PAGE_INDEX = 0

class GithubPagingSource(
    private val datasource: GithubUsersRemoteDatasource
) : RxPagingSource<Int, GithubUserRaw>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, GithubUserRaw>> {
        val position = params.key ?: GITHUB_STARTING_PAGE_INDEX

        return datasource.fetchGithubUsers(position, NETWORK_PAGE_SIZE)
            .subscribeOn(Schedulers.io())
            .map { toLoadResult(it, position) }
            .onErrorReturn { LoadResult.Error(it) }

    }

    private fun toLoadResult(
        data: List<GithubUserRaw>,
        position: Int
    ): LoadResult<Int, GithubUserRaw> {
        val nextKey = if (data.isEmpty()) {
            null
        } else {
            position + NETWORK_PAGE_SIZE
        }
        return LoadResult.Page(
            data = data,
            prevKey = if (position == GITHUB_STARTING_PAGE_INDEX) null else position - NETWORK_PAGE_SIZE,
            nextKey = nextKey
        )
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
