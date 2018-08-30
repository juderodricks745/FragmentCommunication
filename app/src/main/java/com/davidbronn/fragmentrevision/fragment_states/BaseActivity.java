package com.davidbronn.fragmentrevision.fragment_states;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {

    public void addFragment(int container, boolean backstack, Fragment fragment) {
        String tag = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(container, fragment, tag);
        if (backstack) {
            transaction.addToBackStack("add"+tag);
        }
        transaction.commit();
    }

    public void replaceFragment(int container, boolean backstack, Fragment fragment) {
        String tag = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, fragment, tag);
        if (backstack) {
            transaction.addToBackStack("replace"+tag);
        }
        transaction.commit();
    }
}
