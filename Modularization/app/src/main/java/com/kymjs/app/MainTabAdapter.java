package com.kymjs.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


public class MainTabAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public MainTabAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;


    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragments.get(position);

        return fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

