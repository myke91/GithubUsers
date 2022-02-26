package com.myke.sharecare.shared.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myke.sharecare.shared.data.entities.GithubUserRaw

@Dao
interface GithubUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<GithubUserRaw>?)

    @Query("SELECT * FROM GithubUser WHERE login = :username LIMIT 1")
    suspend fun getUserByUsername(username: String): GithubUserRaw?

    @Query("SELECT * FROM GithubUser")
    fun getUsers(): PagingSource<Int, GithubUserRaw>
}