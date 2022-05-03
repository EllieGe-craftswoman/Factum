package com.ellies.factum.home
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ellies.factum.R
import com.ellies.factum.counter.CounterActivity
import com.ellies.factum.goals.FactumListActivity
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase(){

    private lateinit var activity: ActivityScenario<MainActivity>

    @Before
    fun setup(){
        activity = launchActivity()
        activity.moveToState(Lifecycle.State.RESUMED)
        Intents.init()
    }

    @Test
    fun counterButtonClicked_launchesCounterActivity() {
        //Act
        onView(withId(R.id.goToCounterBtn)).perform(click())
        //Assert
        intended(hasComponent(CounterActivity::class.java.name))
    }

    @Test
    fun factumButtonClicked_launchesFactumListActivity(){
        //Act
        onView(withId(R.id.goToGoalsListBtn)).perform(click())
        //Assert
        intended(hasComponent(FactumListActivity::class.java.name))
    }

    @After
    public override fun tearDown(){
        Intents.release()
    }
}