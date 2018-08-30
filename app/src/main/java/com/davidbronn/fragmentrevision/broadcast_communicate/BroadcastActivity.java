package com.davidbronn.fragmentrevision.broadcast_communicate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.ActivityBroadcastBinding;

public class BroadcastActivity extends AppCompatActivity {

    private ActivityBroadcastBinding binding;
    public static final String BROADCAST = "intent_broadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_broadcast);

        getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.frameLayout, BroadCastFragment.newInstance(null), BroadCastFragment.class.getSimpleName())
        .commit();
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("message");
            binding.tvBroadcastText.setText(message);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(BROADCAST));
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
        super.onDestroy();
    }
}
