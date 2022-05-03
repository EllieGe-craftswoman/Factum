package com.ellies.factum.counter

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ellies.factum.R
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterActivityTest : TestCase() {

    private lateinit var activity: ActivityScenario<CounterActivity>

    @Before
    fun setup() {
        activity = launchActivity()
        activity.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun countButtonClicked_counterOnTextViewIncremented(){
        //Arrange
        onView(withId(R.id.countTv))
            .check(matches(withText("Factum Counter Clicks 0")))
            .check(matches(isDisplayed()))
        //Act
        onView(withId(R.id.countBtn)).perform(click())
        //Assert
        onView(withId(R.id.countTv))
            .check(matches(withText("Factum Counter Clicks 1")))

    }

}
