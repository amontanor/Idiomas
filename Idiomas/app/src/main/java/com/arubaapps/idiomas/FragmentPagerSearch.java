package com.arubaapps.idiomas;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentPagerSearch extends FragmentStatePagerAdapter {

    public FragmentPagerSearch(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public Fragment getItem(int position) {
        return(SearchMyResultFragment.newInstance(position));
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return(Integer.toString(position));
    }
}
