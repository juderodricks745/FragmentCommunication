package com.davidbronn.fragmentrevision.inter_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment
{
    private int counter = 0;
    private FragmentSecondBinding binding;
    public SecondFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        binding.dyCounter.setText(String.valueOf(counter));
    }

    public void updateSecondFragCounter()
    {
        counter++;
        binding.dyCounter.setText(String.valueOf(counter));
    }
}
