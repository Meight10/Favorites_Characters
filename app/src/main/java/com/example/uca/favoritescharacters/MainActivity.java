package com.example.uca.favoritescharacters;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements List_Fragment.OnListFragmentInteractionListener{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define TabLayout
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_text_2));


        //define viewPager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.container);

        //fill the list
        Personajes[] charactersListModels0 = createCharactersListModel();
        Personajes[] charactersListModels1 = createCharactersListModel();
        createCharactersListModel();


        //adding a adapter to viewPager
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(), charactersListModels0, charactersListModels1);

        viewPager.setAdapter(adapter);

        //Listener
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(getOnTabSelectedListener(viewPager));


    }

    /**
     * Listener for tab selected
     * @param viewPager
     * @return
     */

    private TabLayout.OnTabSelectedListener getOnTabSelectedListener(final ViewPager viewPager) {
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
    }


    /**
     * Listener that comunicate fragment / recycler with this activity
     * @param model
     */
    @Override
    public void onListFragmentInteraction(Personajes model) {
        // the user clicked on this item over the list
        Toast.makeText(MainActivity.this, Personajes.class.getSimpleName() + ":" + model.getName() + " - "  +model.getDescription(), Toast.LENGTH_LONG).show();
    }

    // model for test purpose
    private Personajes[] createCharactersListModel() {

        List<Personajes> heroes =  new ArrayList<>();

        heroes.add(new Personajes(getString(R.string.character1), getString(R.string.character1Description), R.drawable.sombra));
        heroes.add(new Personajes(getString(R.string.character2), getString(R.string.character2Description), R.drawable.bastion));
        heroes.add(new Personajes(getString(R.string.character3), getString(R.string.character3Description), R.drawable.genji));
        heroes.add(new Personajes(getString(R.string.character4), getString(R.string.character4Description), R.drawable.hanzo));
        heroes.add(new Personajes(getString(R.string.character5), getString(R.string.character5Description), R.drawable.junkrat));
        heroes.add(new Personajes(getString(R.string.character6), getString(R.string.character6Description), R.drawable.mccree));
        heroes.add(new Personajes(getString(R.string.character7), getString(R.string.character7Description), R.drawable.mei));
        heroes.add(new Personajes(getString(R.string.character8), getString(R.string.character8Description), R.drawable.pharah));
        heroes.add(new Personajes(getString(R.string.character9), getString(R.string.character9Description), R.drawable.reaper));
        heroes.add(new Personajes(getString(R.string.character10), getString(R.string.character10Description), R.drawable.soldier76));
        heroes.add(new Personajes(getString(R.string.character11), getString(R.string.character11Description), R.drawable.torbjorn));
        heroes.add(new Personajes(getString(R.string.character12), getString(R.string.character12Description), R.drawable.widowmaker));
        heroes.add(new Personajes(getString(R.string.character13), getString(R.string.character13Description), R.drawable.d_va));
        heroes.add(new Personajes(getString(R.string.character14), getString(R.string.character14Description), R.drawable.orisa));
        heroes.add(new Personajes(getString(R.string.character15), getString(R.string.character15Description), R.drawable.rainhardt));
        heroes.add(new Personajes(getString(R.string.character16), getString(R.string.character16Description), R.drawable.roadhog));
        heroes.add(new Personajes(getString(R.string.character17), getString(R.string.character17Description), R.drawable.winston));
        heroes.add(new Personajes(getString(R.string.character18), getString(R.string.character18Description), R.drawable.zarya));
        heroes.add(new Personajes(getString(R.string.character19), getString(R.string.character19Description), R.drawable.ana));
        heroes.add(new Personajes(getString(R.string.character20), getString(R.string.character20Description), R.drawable.brigitte));
        heroes.add(new Personajes(getString(R.string.character21), getString(R.string.character21Description), R.drawable.lucio));
        heroes.add(new Personajes(getString(R.string.character22), getString(R.string.character22Description), R.drawable.mercy));
        heroes.add(new Personajes(getString(R.string.character23), getString(R.string.character23Description), R.drawable.moira));
        heroes.add(new Personajes(getString(R.string.character24), getString(R.string.character24Description), R.drawable.symmetra));
        heroes.add(new Personajes(getString(R.string.character25), getString(R.string.character25Description), R.drawable.zenyatta));
        heroes.add(new Personajes(getString(R.string.character26), getString(R.string.character26Description), R.drawable.tracer));
        heroes.add(new Personajes(getString(R.string.character27), getString(R.string.character27Description), R.drawable.doomfist));



        return heroes.toArray(new Personajes[heroes.size()]);
    }



}
