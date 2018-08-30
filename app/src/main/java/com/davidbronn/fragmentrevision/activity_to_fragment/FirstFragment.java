package com.davidbronn.fragmentrevision.activity_to_fragment;

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
import com.davidbronn.fragmentrevision.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment implements TextChangedEvent
{
    private FragmentFirstBinding binding;

    public FirstFragment()
    {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        Log.i("FRAGMENT", "onCreateView");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Log.i("FRAGMENT", "onViewCreated");
    }

    @Override
    public void onTextChanged(String string)
    {
        binding.textView.setText(string);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.i("FRAGMENT", "onStart");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.i("FRAGMENT", "onResume");
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        Log.i("FRAGMENT", "onAttach");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.i("FRAGMENT", "onPause");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.i("FRAGMENT", "onStop");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.i("FRAGMENT", "onDestroy");
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        Log.i("FRAGMENT", "onDetach");
    }
}
