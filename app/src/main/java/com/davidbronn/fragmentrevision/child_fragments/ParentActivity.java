package com.davidbronn.fragmentrevision.child_fragments;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.ActivityParentBinding;

public class ParentActivity extends AppCompatActivity implements ParentFragment2ActivityListener, ChildFragment2ParentActivityListener
{
    private ActivityParentBinding binding;
    private Activity2ParentFragmentListener parentFragmentListener;
    private IntermediateListener intermediateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_parent);


        ParentFragment parentFragment = new ParentFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.parent_framelayout, parentFragment).commit();
        parentFragmentListener = parentFragment;
        intermediateListener = parentFragment;

        binding.parentFragment.setOnClickListener(v -> parentFragmentListener.fromActivity2ParentFragment("ACTIVITY 2 PARENT FRAGMENT"));
        binding.childFragment.setOnClickListener(v -> intermediateListener.passMessage("ACTIVITY 2 CHILD FRAGMENT"));
    }

    @Override
    public void sendFromParentFragment2Activity(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void childFragment2ParentActivity(String text)
    {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
