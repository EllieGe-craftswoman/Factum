package com.ellies.factum.goals

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ellies.factum.R
import junit.framework.TestCase
import org.hamcrest.Matcher
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
        val hasItems = getRecyclerViewItemsCount(withId(R.id.factumListRV)) ?: 0 > 0
        assertTrue(hasItems)
    }

    private fun getRecyclerViewItemsCount(matcher: Matcher<View>?): Int? {
        var count :Int? = 0
        onView(matcher).perform(object: ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(RecyclerView::class.java)
            }

            override fun getDescription(): String {
                return "getting no. of items in recyclerview"
            }

            override fun perform(uiController: UiController?, view: View?) {
                count = (view as RecyclerView).adapter?.itemCount
            }

        })
        return count
    }


    // region helper methods

    // endregion helper methods

    // region helper helper classes

    // endregion helper helper classes
}

