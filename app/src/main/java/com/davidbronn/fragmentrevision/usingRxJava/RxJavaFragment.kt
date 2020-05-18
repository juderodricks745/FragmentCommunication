package com.davidbronn.fragmentrevision.usingRxJava

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.davidbronn.fragmentrevision.R
import kotlinx.android.synthetic.main.fragment_rx_java.*

class RxJavaFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_rx_java, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RxPublisher.getInstance()?.listen()?.subscribe {
            it?.let {
                when(it.id) {
                    1 -> {
                        tvFirstName.text = "First Name => ${it.text}"
                    }
                    2 -> {
                        tvLastName.text = "Last Name => ${it.text}"
                    }
                }
            }
        }
    }
}
