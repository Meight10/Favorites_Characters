package com.example.uca.favoritescharacters.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.uca.favoritescharacters.model.Personajes;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    //private int numTabs;

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> stringList = new ArrayList<>();
    private Personajes[] heroesListt0;
    private Personajes[] heroesListt1;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }


    /*public PagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;

    }*/

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        stringList.add(title);
    }
}
