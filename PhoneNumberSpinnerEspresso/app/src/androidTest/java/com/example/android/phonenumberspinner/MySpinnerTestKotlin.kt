package com.example.android.phonenumberspinner

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MySpinnerTestKotlin {

    @get:Rule
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun iterateSpinnerItems() {
        // Get the array of strings
        val labels = mActivityRule.activity.resources.getStringArray(R.array.labels_array)

        for (label in labels) {
            // Given a Spinner which is clicked
            onView(withId(R.id.label_spinner)).perform(click())

            // When a spinner item is clicked
            onData(`is`(label)).perform(click())

            // Then the phone label text view contains the label text
            onView(withId(R.id.text_phonelabel)).check(matches(withText(containsString(label))))
        }
    }
}