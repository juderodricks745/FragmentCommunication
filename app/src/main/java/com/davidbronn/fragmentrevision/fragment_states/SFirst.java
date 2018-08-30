package com.davidbronn.fragmentrevision.fragment_states;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.FragmentSfirstBinding;

public class SFirst extends Fragment {

    private FragmentStarter starter;
    private FragmentSfirstBinding binding;

    public static SFirst newInstance() {
        return new SFirst();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sfirst, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnFirstHome.setOnClickListener(v -> starter.startFragment(true, true, FragmentHandler.SECOND_SECOND));

        binding.btnBack.setOnClickListener(v -> starter.ender());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof FragmentStarter) {
            starter = (FragmentStarter) context;
        }
    }
}
