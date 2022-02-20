package com.myke.sharecare.githubusers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.myke.sharecare.githubusers.user.di.idlingResource
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.hamcrest.core.AllOf
import org.junit.Test

class GithubUserDetailsFeature : BaseUITest() {

    @Test
    fun displaysUserNameAndDetails() {
        navigationToPlaylistDetails(0)

        assertDisplayed(R.id.avatar)

        assertDisplayed(R.id.twitter_username)
    }


    @Test
    fun displaysLoaderWhileFetchingThePlaylistDetails() = runBlocking {
        IdlingRegistry.getInstance().unregister(idlingResource)

        delay(2000)
        navigationToPlaylistDetails(0)

        assertDisplayed(R.id.details_loader)
    }

    @Test
    fun hidesLoader() {
        navigationToPlaylistDetails(0)

        assertNotDisplayed(R.id.details_loader)
    }

    @Test
    fun displaysErrorMessageWhenNetworkFails() {
        navigationToPlaylistDetails(1)

        assertDisplayed(R.string.generic_error)
    }

    @Test
    fun hidesErrorMessage() = runBlocking {
        navigationToPlaylistDetails(3)
        delay(3000)

        assertNotExist(R.string.generic_error)
    }

    private fun navigationToPlaylistDetails(row: Int) {
        onView(
            AllOf.allOf(
                withId(R.id.avatar),
                ViewMatchers.isDescendantOfA(nthChildOf(withId(R.id.users_list), row))
            )
        ).perform(ViewActions.click())
    }
}