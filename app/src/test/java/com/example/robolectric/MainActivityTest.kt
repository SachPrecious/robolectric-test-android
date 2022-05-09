package com.example.robolectric

import android.view.View
import android.widget.TextView
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class MainActivityTest : TestCase(){
    private var activity: MainActivity? = null

    @Before
    @Throws(Exception::class)
    override fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun validateTextViewContent() {
        val txtInActivity = activity!!.findViewById<View>(R.id.txtActivity) as TextView
        assertNotNull("TextView could not be found", txtInActivity)
        assertTrue(
            "Invalid Text",
            "This is the text on an Activity" == txtInActivity.text.toString()
        )
    }

}