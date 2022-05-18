package com.ellies.factum.goals

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ellies.factum.R
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Test

class FactumListActivityTest {

    private lateinit var activity: ActivityScenario<FactumListActivity>

    @Before
    fun setup() {
        activity = launchActivity()
        activity.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun whenActivityLaunched_recyclerViewNotEmpty(){
        //Assert
        onView(withId(R.id.factumListRV)).check(notEmptyRecyclerViewMatcher())
    }

    // region helper methods

    private fun notEmptyRecyclerViewMatcher() = matches( object: TypeSafeMatcher<View>() {
        override fun matchesSafely(item: View?): Boolean {
            val rv = (item as? RecyclerView) ?: throw AssertionError("Expected a RecyclerView, but couldn't cast view provided to RecyclerView.")
            val itemCount =  rv.adapter?.itemCount ?: return false
            return itemCount > 0
        }
        override fun describeTo(description: Description?) {}
    })

    // endregion helper methods

    // region helper helper classes

    // endregion helper helper classes
}

