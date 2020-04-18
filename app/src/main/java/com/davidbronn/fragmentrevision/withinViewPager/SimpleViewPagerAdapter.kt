package com.davidbronn.fragmentrevision.withinViewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class SimpleViewPagerAdapter internal constructor(fm: FragmentManager)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> FirstFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}
