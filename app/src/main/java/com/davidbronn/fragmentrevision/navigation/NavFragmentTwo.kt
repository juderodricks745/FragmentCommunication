package com.davidbronn.fragmentrevision.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.davidbronn.fragmentrevision.R
import kotlinx.android.synthetic.main.fragment_nav_two.*

class NavFragmentTwo : Fragment() {

    private val navArgs: NavFragmentTwoArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_nav_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvReceived.text = "Welcome, ${navArgs.name}"
    }
}
