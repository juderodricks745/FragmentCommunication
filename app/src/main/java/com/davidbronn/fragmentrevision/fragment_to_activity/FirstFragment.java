package com.davidbronn.fragmentrevision.fragment_to_activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.FragmentFirst2Binding;

public class FirstFragment extends Fragment
{
    private OnTextChanged textChanged;
    private FragmentFirst2Binding binding;

    public FirstFragment()
    {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first2, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        binding.editText2.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                textChanged.onTextChanged(s.toString());
            }
        });
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        textChanged = (OnTextChanged) context;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        textChanged = null;
    }
}
