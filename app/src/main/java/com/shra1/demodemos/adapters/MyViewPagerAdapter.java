package com.shra1.demodemos.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shra1.demodemos.dtos.MyFragment;

import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    List<MyFragment> l;

    public MyViewPagerAdapter(FragmentManager fm, List<MyFragment> l) {
        super(fm);
        this.l = l;
    }

    @Override
    public Fragment getItem(int position) {
        return l.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return l.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return l.get(position).getTitle();
    }
}
