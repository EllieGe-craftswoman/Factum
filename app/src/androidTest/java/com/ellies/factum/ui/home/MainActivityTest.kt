package com.ellies.factum.ui.home
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ellies.factum.R
import com.ellies.factum.ui.counter.CounterActivity
import com.ellies.factum.ui.goals.FactumListActivity
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

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
    fun tearDown(){
        Intents.release()
    }
}