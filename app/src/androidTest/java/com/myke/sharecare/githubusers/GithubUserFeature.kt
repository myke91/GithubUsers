package com.myke.sharecare.githubusers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.myke.sharecare.githubusers.user.di.idlingResource
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import org.hamcrest.core.AllOf.allOf
import org.junit.Test


class GithubUserFeature : BaseUITest() {

    @Test
    fun displayScreenTitle() {
        assertDisplayed("GithubUsers")
    }

    @Test
    fun displaysListOfUsers() {

        onView(
            allOf(
                withId(R.id.avatar),
                isDescendantOfA(nthChildOf(withId(R.id.users_list), 0))
            )
        ).check(matches(isDisplayed()))

        onView(
            allOf(
                withId(R.id.nickname),
                isDescendantOfA(nthChildOf(withId(R.id.users_list), 0))
            )
        ).check(matches(isDisplayed()))


    }

    @Test
    fun displaysLoaderWhileFetchingTheUsers() {
        IdlingRegistry.getInstance().unregister(idlingResource)
        assertDisplayed(R.id.loader)
    }

    @Test
    fun showCorrectTypeOfList(){
        assertDisplayed(R.id.nickname)
        onView(withId(R.id.users_list_toolbar)).perform(click())

        assertDisplayed(R.id.url)
        onView(withId(R.id.users_list_toolbar)).perform(click())

    }

    @Test
    fun hidesLoader() {
        assertNotDisplayed(R.id.loader)
    }


    @Test
    fun navigateToDetailScreen() {
        onView(
            allOf(
                withId(R.id.avatar),
                isDescendantOfA(nthChildOf(withId(R.id.users_list), 0))
            )
        ).perform(click())

        assertDisplayed(R.id.user_details_root)
    }


}