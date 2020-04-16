package com.davidbronn.fragmentrevision.inter_fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleViewPagerAdapter extends FragmentPagerAdapter
{
    SimpleViewPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 2;
    }
}
