package com.davidbronn.fragmentrevision.child_fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.FragmentChildBinding;

public class ChildFragment extends Fragment implements ParentFragment2ChildFragmentListener
{
    private FragmentChildBinding binding;
    private ChildFrgment2ParentFragmentListener childFrgment2ParentFragmentListener;
    private ChildFragment2ParentActivityListener childFragment2ParentActivityListener;

    public ChildFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_child, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.parentFragment.setOnClickListener(v -> childFrgment2ParentFragmentListener.childFragment2ParentFragment("CHILD FRAGMENT 2 PARENT FRAGMENT"));
        binding.parentActivity.setOnClickListener(v -> childFragment2ParentActivityListener.childFragment2ParentActivity("CHILD FRAGMENT 2 PARENT ACTIVITY"));
    }

    public void setToastMessage(String textMessage)
    {
        Toast.makeText(getContext(), textMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void parentFragment2ChildFragment(String text)
    {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (getParentFragment() instanceof ChildFrgment2ParentFragmentListener)
        {
            childFrgment2ParentFragmentListener = (ChildFrgment2ParentFragmentListener) getParentFragment();
        }

        if (context instanceof ChildFragment2ParentActivityListener)
        {
            childFragment2ParentActivityListener = (ChildFragment2ParentActivityListener) context;
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        childFrgment2ParentFragmentListener = null;
    }
}
