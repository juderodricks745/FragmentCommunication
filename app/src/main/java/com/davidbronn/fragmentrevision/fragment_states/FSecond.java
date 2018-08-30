package com.davidbronn.fragmentrevision.fragment_states;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.FragmentFsecondBinding;

public class FSecond extends Fragment {

    private FragmentStarter starter;
    private FragmentFsecondBinding binding;

    public static FSecond newInstance() {
        return new FSecond();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fsecond, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnFirstThird.setOnClickListener(v -> {
            starter.startFragment(true, true, FragmentHandler.FIRST_THIRD);
        });

        binding.btnBack.setOnClickListener(v -> {
            starter.ender();
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof FragmentStarter) {
            starter = (FragmentStarter) context;
        }
    }
}
