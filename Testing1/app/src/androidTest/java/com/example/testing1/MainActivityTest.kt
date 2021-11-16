package com.example.testing1

import android.text.style.ClickableSpan
import android.widget.CheckBox
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

   @get:Rule
    public val activityTestRule:ActivityScenarioRule<MainActivity>  = ActivityScenarioRule(MainActivity::class.java)
    @Before
    fun setUp() {

    }
    @Test
    fun btnClickTest(){
        Espresso.onView(withId(R.id.button1)).perform(click())
        Espresso.onView(withId(R.id.checkbox)).check(matches(isChecked()))

        Espresso.onView(withId(R.id.button2)).perform(click())
        Espresso.onView(withId(R.id.checkbox)).check(matches(isNotChecked()))

    }

    @After
    fun tearDown() {
    }
}