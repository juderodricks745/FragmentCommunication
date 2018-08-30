package com.davidbronn.fragmentrevision.inter_fragments;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity implements UpdateSecondFragmentEvent
{
    private SecondFragment secondFragment;
    private SimpleViewPagerAdapter adapter;
    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main3);

        adapter = new SimpleViewPagerAdapter(getSupportFragmentManager());
        binding.viewPager.setAdapter(adapter);
    }

    @Override
    public void incrementCounter()
    {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag(tag);
        secondFragment.updateSecondFragCounter();
    }
}
