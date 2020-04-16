package com.davidbronn.fragmentrevision.activityToFragment

import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.databinding.ActivityMainBinding
import com.davidbronn.fragmentrevision.utils.BaseActivity
import com.davidbronn.fragmentrevision.utils.TextChangedEvent

class MainActivity : BaseActivity() {

    private var binding: ActivityMainBinding? = null
    private var changedEvent: TextChangedEvent? = null

    private val fragment by lazy { FirstFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        addFragment(R.id.frameLayout, fragment)
        changedEvent = fragment

        binding?.editText?.addTextChangedListener {
            changedEvent?.onTextChanged(it.toString())
        }
    }
}
