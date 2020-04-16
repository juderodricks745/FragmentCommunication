package com.davidbronn.fragmentrevision.fragmentToActivity

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.databinding.FragmentFirst2Binding
import com.davidbronn.fragmentrevision.utils.TextChangedEvent

class FirstFragment : Fragment() {

    private var counter = 0
    private var textChanged: TextChangedEvent? = null
    private var binding: FragmentFirst2Binding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        textChanged = context as TextChangedEvent
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first2, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding?.tvProductCount?.text = "0"
        binding?.fabDecrease?.setOnClickListener {
            if (counter <= 0) {
                Toast.makeText(activity, "Count cannot be lower!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            counter--
            binding?.tvProductCount?.text = "$counter"
            textChanged?.onTextChanged("$counter")
        }

        binding?.fabIncrease?.setOnClickListener {
            counter++
            binding?.tvProductCount?.text = "$counter"
            textChanged?.onTextChanged("$counter")
        }
    }
}
