package com.example.testing2

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.testing2.R.style.ThemeOverlay_MaterialComponents_Light

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnit
import org.mockito.Mockito

import org.mockito.junit.MockitoRule
import javax.inject.Inject


@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerFragmentTest {

    private lateinit var scenario:FragmentScenario<RecyclerFragment>

    @Rule
    var rule: MockitoRule? = MockitoJUnit.rule()


    @Inject
    val recyclerviewClicklistener:RecyclerviewClicklistener = Mockito.mock(RecyclerviewClicklistener::class.java)


    @Before
    fun setUp() {
        scenario = launchFragmentInContainer(themeResId = ThemeOverlay_MaterialComponents_Light)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun checkFragment()
    {
        val recyclerFragment:RecyclerFragment = Mockito.mock(RecyclerFragment::class.java)
        val dataFragment:DataFragment = Mockito.mock(DataFragment::class.java)


    }

    @After
    fun tearDown() {
    }
}