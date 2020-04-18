package com.davidbronn.fragmentrevision.withinViewPager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Jude on 17/April/2020
 */
class SharedViewModel : ViewModel() {

    val name = MutableLiveData<String>().apply { value = "" }
}