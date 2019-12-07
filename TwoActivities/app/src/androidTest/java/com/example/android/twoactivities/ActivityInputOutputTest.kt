package com.example.android.twoactivities

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityInputOutputTest {

    @get:Rule
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun activityLaunch() {
        // Test that when send button is clicked, SecondActivity is launched and text header is visible
        onView(withId(R.id.button_main)).perform(click())
        onView(withId(R.id.text_header))
                .check(matches(isDisplayed()))

        // Test that when the SecondActivity is launched and the button is clicked,
        // then the text header reply text view is visible
        onView(withId(R.id.button_second)).perform(click())
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()))

    }

    @Test
    fun testInputOutput() {
        //Given a text in the main edit text
        onView(withId(R.id.editText_main)).perform(typeText("Hello there"))

        //When the send button is clicked
        onView(withId(R.id.button_main)).perform(click())

        //Then the same text is displayed in the text message edit text
        onView(withId(R.id.text_message)).check(matches(withText("Hello there")))
    }
}