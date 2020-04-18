package com.davidbronn.fragmentrevision.withinViewPager

import android.os.Bundle

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.databinding.ActivityMain3Binding
import com.davidbronn.fragmentrevision.utils.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var viewModel: SharedViewModel
    private var binding: ActivityMain3Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main3)
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        binding?.viewPager?.adapter = SimpleViewPagerAdapter(supportFragmentManager)
    }
}
