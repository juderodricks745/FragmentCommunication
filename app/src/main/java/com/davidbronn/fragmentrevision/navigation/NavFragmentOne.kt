package com.davidbronn.fragmentrevision.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.davidbronn.fragmentrevision.R
import kotlinx.android.synthetic.main.fragment_nav_one.*

class NavFragmentOne : NavBaseFragment() {

    private var liveData: MutableLiveData<Bundle>? = MutableLiveData<Bundle>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_nav_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navigator = findNavController()

        btnStartFragmentTwo.setOnClickListener {
            NavFragmentOneDirections.oneToTwo().apply {
                name = edName.text.toString()
                navigator.navigate(this)
            }
        }

        liveData = navigator.getLiveDataKey("data")
        liveData?.observe(viewLifecycleOwner, Observer { bundle ->
            Toast.makeText(requireActivity(), "${bundle.getString("timeMillis")}", Toast.LENGTH_LONG).show()
        })
    }
}
