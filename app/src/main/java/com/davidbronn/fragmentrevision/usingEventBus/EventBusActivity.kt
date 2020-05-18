package com.davidbronn.fragmentrevision.usingEventBus

import android.os.Bundle
import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.utils.BaseActivity
import kotlinx.android.synthetic.main.activity_event_bus.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class EventBusActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_bus)

        addFragment(R.id.content_main, EventBusParentFragment())
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent?) {
        tvUserName.text = "Welcome, ${event!!.name}"
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this);
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}
