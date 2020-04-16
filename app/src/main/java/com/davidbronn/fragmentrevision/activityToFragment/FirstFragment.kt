package com.davidbronn.fragmentrevision.activityToFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.databinding.FragmentFirstBinding
import com.davidbronn.fragmentrevision.utils.TextChangedEvent

class FirstFragment : Fragment(), TextChangedEvent {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return binding.root
    }

    override fun onTextChanged(string: String) {
        binding.textView.text = string
    }
}
