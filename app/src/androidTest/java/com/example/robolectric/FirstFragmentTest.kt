package com.example.robolectric

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FirstFragmentTest : TestCase(){


    private var activity: MainActivity? = null
    private var fragment: FirstFragment? = null


    @Before
    @Throws(Exception::class)
    override fun setUp(){
        fragment = FirstFragment()
        activity = Robolectric.buildActivity(
            MainActivity::class.java
        ).create().start()
            .resume()
            .get()

        val fragmentManager:FragmentManager=activity!!.supportFragmentManager
        val fragmentTransaction:FragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment!!,null)
        fragmentTransaction.commit()

    }

    @Test
    fun it_should_validate_the_textViewFragment() {
        val tvFragment : TextView = activity!!.findViewById<TextView>(R.id.txtFragment)
        Assert.assertNotNull("TextView could not be found", tvFragment)
        Assert.assertTrue(
            "TextView contains incorrect text",
            "This is text on a Fragment" == tvFragment.text.toString()
        )
    }


}



