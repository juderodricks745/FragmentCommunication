package com.davidbronn.fragmentrevision.fragment_to_activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity implements OnTextChanged
{
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);

        FirstFragment fragment = new FirstFragment();
        getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.frameLayout, fragment)
        .commit();
    }

    @Override
    public void onTextChanged(String text)
    {
        binding.name.setText(text);
    }
}
