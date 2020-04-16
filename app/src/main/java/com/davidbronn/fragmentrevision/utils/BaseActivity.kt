package com.davidbronn.fragmentrevision.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseActivity : AppCompatActivity() {

    fun addFragment(container: Int, fragment: Fragment, keepInStack: Boolean = true) {
        val tag = fragment.javaClass.name
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(container, fragment, tag)
        if (keepInStack) {
            transaction.addToBackStack("add$tag")
        }
        transaction.commit()
    }

    fun replaceFragment(container: Int, fragment: Fragment, keepInStack: Boolean = true) {
        val tag = fragment.javaClass.name
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(container, fragment, tag)
        if (keepInStack) {
            transaction.addToBackStack("replace$tag")
        }
        transaction.commit()
    }
}
