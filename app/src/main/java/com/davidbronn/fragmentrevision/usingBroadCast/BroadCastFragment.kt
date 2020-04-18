package com.davidbronn.fragmentrevision.usingBroadCast

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.databinding.FragmentBroadCastBinding

class BroadCastFragment : Fragment() {

    private var binding: FragmentBroadCastBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_broad_cast, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.edQueryText?.addTextChangedListener {
            broadCastMessage(it.toString())
        }
    }

    private fun broadCastMessage(message: String) {
        val intent = Intent(MainActivity.BROADCAST)
        intent.putExtra("message", message)
        LocalBroadcastManager.getInstance(activity!!).sendBroadcast(intent)
    }
}
