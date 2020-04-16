package com.davidbronn.fragmentrevision.fragmentToActivity

import android.os.Bundle

import androidx.databinding.DataBindingUtil

import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.databinding.ActivityMain2Binding
import com.davidbronn.fragmentrevision.utils.BaseActivity
import com.davidbronn.fragmentrevision.utils.TextChangedEvent

class MainActivity : BaseActivity(), TextChangedEvent {
    private var binding: ActivityMain2Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        addFragment(R.id.frameLayout, FirstFragment())
    }

    override fun onTextChanged(text: String) {
        binding?.badge?.setNumber(text.toInt())
    }
}
