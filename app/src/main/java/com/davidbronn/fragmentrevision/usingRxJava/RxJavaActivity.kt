package com.davidbronn.fragmentrevision.usingRxJava

import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.utils.BaseActivity
import kotlinx.android.synthetic.main.activity_rx_java.*

class RxJavaActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)

        RxPublisher.getInstance()
        addFragment(R.id.content_main, RxJavaFragment())

        edFirstName.addTextChangedListener {
            edFirstName publishWithId 1
        }

        edlastName.addTextChangedListener {
            edlastName publishWithId 2
        }
    }

    private infix fun EditText.publishWithId(id: Int) {
        RxPublisher.getInstance()?.publish(RxEvent(id, this.text.toString()))
    }
}
