package com.ellies.factum.goals

import android.view.View
import androidx.annotation.IdRes
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ellies.factum.R
import junit.framework.TestCase
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FactumListActivityTest : TestCase(){

    private lateinit var activity: ActivityScenario<FactumListActivity>

    @Before
    fun setup() {
        activity = launchActivity()
        activity.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun whenActivityLaunched_recyclerViewNotEmpty(){
        //Assert
        checkForRecyclerViewNotEmpty(R.id.factumListRV)
    }

    private fun checkForRecyclerViewNotEmpty(@IdRes rvID: Int){
        onView(withId(rvID)).check(
            matches( object: TypeSafeMatcher<View>() {
                override fun matchesSafely(item: View?): Boolean {
                    val rv = (item as? RecyclerView) ?: return false
                    val itemCount =  rv.adapter?.itemCount ?: return false
                    return itemCount > 0
                }

                override fun describeTo(description: Description?) {}

            })
        )
    }




    // region helper methods

    // endregion helper methods

    // region helper helper classes

    // endregion helper helper classes
}

