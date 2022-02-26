package com.myke.sharecare.shared.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "githubUser")
data class GithubUser(
    @PrimaryKey val user: String,
    val avatarUrl: String,
    val profileUrl: String
)
