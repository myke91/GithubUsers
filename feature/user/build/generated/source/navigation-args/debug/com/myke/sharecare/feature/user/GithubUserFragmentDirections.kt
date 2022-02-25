package com.myke.sharecare.feature.user

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

class GithubUserFragmentDirections private constructor() {
  private data class ActionGithubUserFragmentToGithubUserDetailFragment(
    val user: String
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_githubUserFragment_to_githubUserDetailFragment

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("user", this.user)
      return result
    }
  }

  companion object {
    fun actionGithubUserFragmentToGithubUserDetailFragment(user: String): NavDirections =
        ActionGithubUserFragmentToGithubUserDetailFragment(user)
  }
}
