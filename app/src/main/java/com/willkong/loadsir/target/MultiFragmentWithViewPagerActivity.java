package com.willkong.loadsir.target;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.willkong.loadstate.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:TODO
 * Create Time:2017/9/4 10:56
 */

public class MultiFragmentWithViewPagerActivity extends AppCompatActivity {
    private List<Fragment> fragments = new ArrayList<>();
    private String[] tabTitles = {"Fragment A", "Fragment B"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_viewpager);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);

        fragments.add(new FragmentA());
        fragments.add(new FragmentB());
        viewpager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabMode(TabLayout.MODE_FIXED);

    }

    private class PagerAdapter extends FragmentPagerAdapter {

        PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }


}
