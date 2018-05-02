package com.example.uca.favoritescharacters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numTabs;

    private final List<Fragment> fragmentList = new ArrayList<>();
    private Personajes[] heroesListt0;
    private Personajes[] heroesListt1;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }


    public PagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;

    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return numTabs;
    }

    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }
}
