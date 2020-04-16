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
import com.davidbronn.fragmentrevision.databinding.FragmentParentBinding;

public class ParentFragment extends Fragment implements Activity2ParentFragmentListener, IntermediateListener, ChildFrgment2ParentFragmentListener
{
    private ChildFragment childFragment;
    private FragmentParentBinding binding;
    private ParentFragment2ActivityListener parentFragment2ActivityListener;
    private ParentFragment2ChildFragmentListener parentFragment2ChildFragmentListener;

    public ParentFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_parent, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        childFragment = new ChildFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.child_framelayout, childFragment).commit();
        parentFragment2ChildFragmentListener = childFragment;

        binding.parentActivity.setOnClickListener(v -> parentFragment2ActivityListener.sendFromParentFragment2Activity("PARENT FRAGMENT 2 ACTIVITY"));
        binding.childFragment.setOnClickListener(v -> parentFragment2ChildFragmentListener.parentFragment2ChildFragment("PARENT FRAGMENT 2 CHILD FRAGMENT"));
    }

    @Override
    public void fromActivity2ParentFragment(String text)
    {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passMessage(String textMaessage)
    {
        childFragment.setToastMessage(textMaessage);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        parentFragment2ActivityListener = (ParentFragment2ActivityListener) context;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        parentFragment2ActivityListener = null;
    }

    @Override
    public void childFragment2ParentFragment(String text)
    {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
