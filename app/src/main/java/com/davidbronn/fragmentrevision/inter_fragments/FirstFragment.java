package com.davidbronn.fragmentrevision.inter_fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.FragmentFirst3Binding;

public class FirstFragment extends Fragment
{
    private FragmentFirst3Binding binding;
    private UpdateSecondFragmentEvent listener;
    public FirstFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first3, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        int counter = 0;
        binding.dyCounter.setText(String.valueOf(counter));

        binding.dsButton.setOnClickListener(v -> listener.incrementCounter());
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        listener = (UpdateSecondFragmentEvent) context;
    }
}
