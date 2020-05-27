package com.davidbronn.fragmentrevision.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.davidbronn.fragmentrevision.R
import kotlinx.android.synthetic.main.fragment_nav_one.*

class NavFragmentOne : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_nav_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnStartFragmentTwo.setOnClickListener {
            NavFragmentOneDirections.oneToTwo().apply {
                name = edName.text.toString()
                Navigation.findNavController(btnStartFragmentTwo).navigate(this)
            }
        }
    }
}
