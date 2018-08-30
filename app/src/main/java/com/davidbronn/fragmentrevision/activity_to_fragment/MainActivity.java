package com.davidbronn.fragmentrevision.activity_to_fragment;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.davidbronn.fragmentrevision.R;
import com.davidbronn.fragmentrevision.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding binding;
    private TextChangedEvent changedEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        String TAG = "SAMPLE";
        FirstFragment firstFragment = new FirstFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, firstFragment, TAG).commit();
        changedEvent = firstFragment;

        binding.editText.setOnEditorActionListener((v, actionId, event) ->
        {
            if(actionId == EditorInfo.IME_ACTION_DONE)
            {
                changedEvent.onTextChanged(binding.editText.getText().toString());
                return true;
            }
            return false;
        });
    }
}
