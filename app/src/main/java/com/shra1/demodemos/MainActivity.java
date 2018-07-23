package com.shra1.demodemos;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ogaclejapan.smarttablayout.SmartTabIndicationInterpolator;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.shra1.demodemos.adapters.MyViewPagerAdapter;
import com.shra1.demodemos.dtos.MyFragment;
import com.shra1.demodemos.fragments.AlarmManagerDemoFragment;
import com.shra1.demodemos.fragments.DataListFragment;
import com.shra1.demodemos.fragments.LVContextualActionModeDemoFragment;
import com.shra1.demodemos.fragments.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static MainActivity INSTANCE = null;
    public Toolbar tbToolbar;
    public SmartTabLayout stlTabs;
    public ViewPager vpViewPager;

    public static MainActivity getInstance() {
        return INSTANCE;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setSupportActionBar(tbToolbar);

        List<MyFragment> myFragments = new ArrayList<>();
        myFragments.add(new MyFragment(LVContextualActionModeDemoFragment.getInstance(), "ListView Contextual Action Mode"));
        myFragments.add(new MyFragment(AlarmManagerDemoFragment.getInstance(), "Alarm Demo"));
        myFragments.add(new MyFragment(DataListFragment.getInstance(), "Data List"));
        myFragments.add(new MyFragment(SettingsFragment.getInstance(), "Settings"));

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), myFragments);
        vpViewPager.setAdapter(adapter);

        stlTabs.setViewPager(vpViewPager);

        int indicatorHeight = stlTabs.getHeight();


        INSTANCE = this;

    }

    @Override
    protected void onResume() {
        super.onResume();
        INSTANCE = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        INSTANCE = null;
    }

    private void initViews() {
        tbToolbar = (Toolbar) findViewById(R.id.tbToolbar);
        stlTabs = (SmartTabLayout) findViewById(R.id.stlTabs);
        vpViewPager = (ViewPager) findViewById(R.id.vpViewPager);
    }
}
