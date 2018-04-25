package com.example.uca.favoritescharacters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numTabs;
    private Personajes[] heroesListt0;
    private Personajes[] heroesListt1;

    public PagerAdapter(FragmentManager fm, int numTabs, Personajes[] heroesListt0, Personajes[] heroesListt1) {
        super(fm);
        this.numTabs = numTabs;
        this.heroesListt0 = heroesListt0;
        this.heroesListt1 = heroesListt1;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                List_Fragment tab1 = List_Fragment.newInstance(heroesListt0);
                return tab1;
            case 1:
                List_Fragment tab2 = List_Fragment.newInstance(heroesListt1);
                return tab2;
            default:
                throw new RuntimeException("Tab position invalid" + position);
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
