package com.davidbronn.fragmentrevision.withinViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.databinding.FragmentFirst3Binding

class FirstFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private lateinit var binding: FragmentFirst3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(activity!!).get(SharedViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first3, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editText?.addTextChangedListener {
            viewModel.name.value = it.toString()
        }
    }
}
