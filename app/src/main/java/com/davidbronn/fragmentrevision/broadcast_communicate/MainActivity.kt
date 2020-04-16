package com.davidbronn.fragmentrevision.broadcast_communicate

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.davidbronn.fragmentrevision.R
import com.davidbronn.fragmentrevision.databinding.ActivityBroadcastBinding
import com.davidbronn.fragmentrevision.utils.BaseActivity

class MainActivity : BaseActivity() {

    private var binding: ActivityBroadcastBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_broadcast)

        addFragment(R.id.frameLayout, BroadCastFragment())
    }

    override fun onResume() {
        super.onResume()
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, IntentFilter(BROADCAST))
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver)
        super.onDestroy()
    }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            binding?.tvBroadcastText?.text = intent.getStringExtra("message")
        }
    }

    companion object {
        const val BROADCAST = "intent_broadcast"
    }
}
