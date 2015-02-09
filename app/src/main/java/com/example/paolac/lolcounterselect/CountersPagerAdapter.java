package com.example.paolac.lolcounterselect;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class CountersPagerAdapter extends FragmentPagerAdapter {
    public CountersPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ArrayListFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Tab One";
            case 1:
                return "Tab Two";
            case 2:
                return "Tab Three";
        }

        return null;
    }
}
