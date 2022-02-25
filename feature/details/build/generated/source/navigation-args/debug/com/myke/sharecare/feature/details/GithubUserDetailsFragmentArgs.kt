package com.myke.sharecare.feature.details

import android.os.Bundle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

data class GithubUserDetailsFragmentArgs(
  val user: String
) : NavArgs {
  fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("user", this.user)
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): GithubUserDetailsFragmentArgs {
      bundle.setClassLoader(GithubUserDetailsFragmentArgs::class.java.classLoader)
      val __user : String?
      if (bundle.containsKey("user")) {
        __user = bundle.getString("user")
        if (__user == null) {
          throw IllegalArgumentException("Argument \"user\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"user\" is missing and does not have an android:defaultValue")
      }
      return GithubUserDetailsFragmentArgs(__user)
    }
  }
}
