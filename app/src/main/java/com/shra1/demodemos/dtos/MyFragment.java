package com.shra1.demodemos.dtos;

import android.support.v4.app.Fragment;

public class MyFragment {
    Fragment fragment;
    String title;

    public MyFragment(Fragment fragment, String title) {

        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
