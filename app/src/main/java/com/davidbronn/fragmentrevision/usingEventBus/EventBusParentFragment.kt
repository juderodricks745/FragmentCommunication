package com.davidbronn.fragmentrevision.usingEventBus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.davidbronn.fragmentrevision.R
import kotlinx.android.synthetic.main.fragment_event_bus_parent.*
import org.greenrobot.eventbus.EventBus

class EventBusParentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event_bus_parent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSetUserName.setOnClickListener {
            EventBus.getDefault().post(MessageEvent(edUserName.text.toString()))
        }
    }
}
