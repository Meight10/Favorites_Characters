package com.example.uca.favoritescharacters;

import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements List_Fragment.OnListFragmentInteractionListener, List_Fragment.OnListFragmentInteractionIcon{


    public static ArrayList<Personajes> charactersListModels0;
    public static ArrayList<Personajes> charactersListModels1;

    public static PagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            charactersListModels0 = new ArrayList<>();
            charactersListModels1 = new ArrayList<>();

            createCharactersListModes0();
        }


        initComponents();

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void initComponents(){

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        //tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_1));
        //tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_2));

        List_Fragment fragment1 = List_Fragment.newInstance("s0", charactersListModels0);
        List_Fragment fragment2 = List_Fragment.newInstance("s1", charactersListModels1);
        System.out.println(charactersListModels1.toString() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        adapter = new PagerAdapter(getSupportFragmentManager());

        adapter.addFragment(fragment1, getString(R.string.tab_text_1));
        adapter.addFragment(fragment2, getString(R.string.tab_text_2));
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }




    /*/**
     * Listener for tab selected
     * @param viewPager
     * @return
     */

   /* private TabLayout.OnTabSelectedListener getOnTabSelectedListener(final ViewPager viewPager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Toast.makeText(MainActivity.this, "Tab selected " +  tab.getPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // nothing now
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // nothing now
            }
        };
    }*/


    /**
     * Listener that comunicate fragment / recycler with this activity
     * @param model
     */
   @Override
    public void onListFragmentInteraction(Personajes model) {
        // the user clicked on this item over the list
        Toast.makeText(MainActivity.this, Personajes.class.getSimpleName() + " : " + model.getName() + " - "  +model.getDescription(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListFragmentInteractionIcon(Personajes item, int position) {
        int index = charactersListModels0.indexOf(item);
       if(item.getFavorite()){
           charactersListModels1.remove(charactersListModels0.get(index));
           charactersListModels0.get(index).setFavorite(false);
           System.out.println("CHANGEED TO FALSE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
           adapter.notifyDataSetChanged();
       }else{
           charactersListModels1.add(charactersListModels0.get(index));
           charactersListModels0.get(index).setFavorite(true);
           System.out.println("CHANGEED TO TRUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
           adapter.notifyDataSetChanged();
       }

    }

    // model for test purpose
    private void createCharactersListModes0() {

        charactersListModels0.add(new Personajes(getString(R.string.character1), getString(R.string.character1Description), R.drawable.sombra, false));
        charactersListModels0.add(new Personajes(getString(R.string.character2), getString(R.string.character2Description), R.drawable.bastion, false));
        charactersListModels0.add(new Personajes(getString(R.string.character3), getString(R.string.character3Description), R.drawable.genji, false));
        charactersListModels0.add(new Personajes(getString(R.string.character4), getString(R.string.character4Description), R.drawable.hanzo, false));
        charactersListModels0.add(new Personajes(getString(R.string.character5), getString(R.string.character5Description), R.drawable.junkrat, false));
        charactersListModels0.add(new Personajes(getString(R.string.character6), getString(R.string.character6Description), R.drawable.mccree, false));
        charactersListModels0.add(new Personajes(getString(R.string.character7), getString(R.string.character7Description), R.drawable.mei, false));
        charactersListModels0.add(new Personajes(getString(R.string.character8), getString(R.string.character8Description), R.drawable.pharah, false));
        charactersListModels0.add(new Personajes(getString(R.string.character9), getString(R.string.character9Description), R.drawable.reaper, false));
        charactersListModels0.add(new Personajes(getString(R.string.character10), getString(R.string.character10Description), R.drawable.soldier76, false));
        charactersListModels0.add(new Personajes(getString(R.string.character11), getString(R.string.character11Description), R.drawable.torbjorn, false));
        charactersListModels0.add(new Personajes(getString(R.string.character12), getString(R.string.character12Description), R.drawable.widowmaker, false));
        charactersListModels0.add(new Personajes(getString(R.string.character13), getString(R.string.character13Description), R.drawable.d_va, false));
        charactersListModels0.add(new Personajes(getString(R.string.character14), getString(R.string.character14Description), R.drawable.orisa, false));
        charactersListModels0.add(new Personajes(getString(R.string.character15), getString(R.string.character15Description), R.drawable.rainhardt, false));
        charactersListModels0.add(new Personajes(getString(R.string.character16), getString(R.string.character16Description), R.drawable.roadhog, false));
        charactersListModels0.add(new Personajes(getString(R.string.character17), getString(R.string.character17Description), R.drawable.winston, false));
        charactersListModels0.add(new Personajes(getString(R.string.character18), getString(R.string.character18Description), R.drawable.zarya, false));
        charactersListModels0.add(new Personajes(getString(R.string.character19), getString(R.string.character19Description), R.drawable.ana, false));
        charactersListModels0.add(new Personajes(getString(R.string.character20), getString(R.string.character20Description), R.drawable.brigitte, false));
        charactersListModels0.add(new Personajes(getString(R.string.character21), getString(R.string.character21Description), R.drawable.lucio, false));
        charactersListModels0.add(new Personajes(getString(R.string.character22), getString(R.string.character22Description), R.drawable.mercy, false));
        charactersListModels0.add(new Personajes(getString(R.string.character23), getString(R.string.character23Description), R.drawable.moira, false));
        charactersListModels0.add(new Personajes(getString(R.string.character24), getString(R.string.character24Description), R.drawable.symmetra, false));
        charactersListModels0.add(new Personajes(getString(R.string.character25), getString(R.string.character25Description), R.drawable.zenyatta, false));
        charactersListModels0.add(new Personajes(getString(R.string.character26), getString(R.string.character26Description), R.drawable.tracer, false));
        charactersListModels0.add(new Personajes(getString(R.string.character27), getString(R.string.character27Description), R.drawable.doomfist, false));

    }



}
