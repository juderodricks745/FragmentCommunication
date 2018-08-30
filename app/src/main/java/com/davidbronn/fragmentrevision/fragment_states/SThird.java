package com.davidbronn.fragmentrevision.fragment_states;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidbronn.fragmentrevision.R;

public class SThird extends Fragment {

    public static SThird newInstance() {
        return new SThird();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sthird, container, false);
    }
}
