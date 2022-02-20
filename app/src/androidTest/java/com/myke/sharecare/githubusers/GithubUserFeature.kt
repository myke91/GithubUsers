package com.myke.sharecare.githubusers

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.myke.sharecare.githubusers.user.di.idlingResource
import com.schibsted.spain.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.schibsted.spain.barista.internal.matcher.DrawableMatcher.Companion.withDrawable
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf.allOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


class GithubUserFeature : BaseUITest() {

    @Test
    fun displayScreenTitle() {
        assertDisplayed("GithubUsers")
    }

    @Test
    fun displaysListOfPlaylists() {

        assertRecyclerViewItemCount(R.id.users_list, 10)

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
    fun displaysLoaderWhileFetchingThePlaylists() {
        IdlingRegistry.getInstance().unregister(idlingResource)
        assertDisplayed(R.id.loader)
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