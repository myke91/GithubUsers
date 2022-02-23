package com.myke.sharecare.githubusers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.myke.sharecare.githubusers.user.di.idlingResource
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.hamcrest.core.AllOf
import org.junit.Test

class GithubUserDetailsFeature : BaseUITest() {

    @Test
    fun displaysProvidedUserDetails() {
        navigationToUserDetails(0)

        assertDisplayed(R.id.user_image)

        assertDisplayed(R.id.username)

        assertDisplayed(R.id.profile_url)

        assertDisplayed(R.id.name)

        assertDisplayed(R.id.twitter_username)

        assertDisplayed(R.id.company)

        assertDisplayed(R.id.location)

        assertDisplayed(R.id.blog)

        assertDisplayed(R.id.email)
    }


    @Test
    fun displaysLoaderWhileFetchingTheUserDetails() = runBlocking {
        IdlingRegistry.getInstance().unregister(idlingResource)

        delay(2000)
        navigationToUserDetails(0)

        assertDisplayed(R.id.details_loader)
    }

    @Test
    fun hidesLoader() = runBlocking {
        navigationToUserDetails(0)
        delay(2000)

        assertNotDisplayed(R.id.details_loader)
    }

    private fun navigationToUserDetails(row: Int) {
        onView(
            AllOf.allOf(
                withId(R.id.avatar),
                ViewMatchers.isDescendantOfA(nthChildOf(withId(R.id.users_list), row))
            )
        ).perform(ViewActions.click())
    }
}