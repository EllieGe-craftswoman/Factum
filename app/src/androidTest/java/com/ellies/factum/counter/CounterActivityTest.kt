package com.ellies.factum.counter

import android.view.View
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import com.ellies.factum.R
import com.ellies.factum.home.MainActivity
import junit.framework.TestCase
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterActivityTest : TestCase() {

    private lateinit var activity: ActivityScenario<CounterActivity>

    @Before
    public override fun setUp() {
        //TODO: SEARCH FOR USE super.setUp()
        activity = launchActivity()
        activity.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun countButtonClicked_counterOnTextViewIncremented(){
        assertEquals("Factum Counter Clicks 0", getText(withId(R.id.countTv)))
        onView(withId(R.id.countBtn)).perform(click())
        assertEquals("Factum Counter Clicks 1", getText(withId(R.id.countTv)))
    }

    @After
    public override fun tearDown() {

    }

    //helper methods
    open fun getText(matcher: Matcher<View?>?): String? {
        val stringHolder = arrayOf<String?>(null)
        onView(matcher).perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(TextView::class.java)
            }

            override fun getDescription(): String {
                return "getting text from a TextView"
            }

            override fun perform(uiController: UiController?, view: View) {
                stringHolder[0] = (view as TextView).text.toString()
            }
        })
        return stringHolder[0]
    }
    //end helper methods

}