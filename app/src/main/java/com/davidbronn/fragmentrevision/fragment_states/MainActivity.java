package com.davidbronn.fragmentrevision.fragment_states;

import android.os.Bundle;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.ActivityMain4Binding;

public class MainActivity extends BaseActivity implements FragmentStarter {

    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main4);

        startFragment(true, false, FragmentHandler.FIRST_FIRST);

        binding.tvFirst.setOnClickListener(v -> {
            binding.tvFirst.setTextColor(ActivityCompat.getColor(this, R.color.colorAccent));
            binding.tvSecond.setTextColor(ActivityCompat.getColor(this, R.color.colorBlack));
            binding.tvThird.setTextColor(ActivityCompat.getColor(this, R.color.colorBlack));
            startFragment(true, false, FragmentHandler.FIRST_FIRST);
        });
        binding.tvFirst.performClick();

        binding.tvSecond.setOnClickListener(v -> {
            binding.tvFirst.setTextColor(ActivityCompat.getColor(this, R.color.colorBlack));
            binding.tvSecond.setTextColor(ActivityCompat.getColor(this, R.color.colorAccent));
            binding.tvThird.setTextColor(ActivityCompat.getColor(this, R.color.colorBlack));
            locateHome();
            startFragment(true, true, FragmentHandler.SECOND_FIRST);
        });

        binding.tvThird.setOnClickListener(v -> {
            binding.tvFirst.setTextColor(ActivityCompat.getColor(this, R.color.colorBlack));
            binding.tvSecond.setTextColor(ActivityCompat.getColor(this, R.color.colorBlack));
            binding.tvThird.setTextColor(ActivityCompat.getColor(this, R.color.colorAccent));
        });
    }

    @Override
    public void ender() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public void locateHome() {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void startFragment(boolean addfragment, boolean backstack, int position) {
        switch (position) {
            case FragmentHandler.FIRST_FIRST:
                addFragment(R.id.frameLayout, backstack, FFirst.newInstance());
                break;
            case FragmentHandler.FIRST_SECOND:
                addFragment(R.id.frameLayout, backstack, FSecond.newInstance());
                break;
            case FragmentHandler.FIRST_THIRD:
                addFragment(R.id.frameLayout, backstack, FThird.newInstance());
                break;
            case FragmentHandler.SECOND_FIRST:
                addFragment(R.id.frameLayout, backstack, SFirst.newInstance());
                break;
            case FragmentHandler.SECOND_SECOND:
                addFragment(R.id.frameLayout, backstack, SSecond.newInstance());
                break;
            case FragmentHandler.SECOND_THIRD:
                addFragment(R.id.frameLayout, backstack, SThird.newInstance());
                break;
        }
    }
}
