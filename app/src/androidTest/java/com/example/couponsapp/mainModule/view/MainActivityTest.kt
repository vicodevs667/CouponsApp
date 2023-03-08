package com.example.couponsapp.mainModule.view


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.couponsapp.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(700)

        val textInputEditText = onView(
            allOf(
                withId(R.id.etCoupon), withContentDescription("cup�n"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilCoupon),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(click())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.etCoupon), withContentDescription("cup�n"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilCoupon),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(click())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.etCoupon), withContentDescription("cup�n"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilCoupon),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText("udemy01"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.btnConsult), withText("Consultar"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.etDescription), withContentDescription("Descripci�n"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.tilDescription),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(replaceText("test"), closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.btnCreate), withText("Crear cup�n"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val snackbar = onView(withId(com.google.android.material.R.id.snackbar_text))
        snackbar.check(matches(withText("Cupón creado.")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
