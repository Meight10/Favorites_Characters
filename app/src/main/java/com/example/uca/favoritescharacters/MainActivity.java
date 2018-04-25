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
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //define viewPager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.container);

        //fill the list
        charactersList = createCharactersListModel();
        createCharactersListModel();


        //adding a adapter to viewPager
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(), charactersList);

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

        heroes.add(new Personajes("Sombra", "", R.drawable.sombra));
        heroes.add(new Personajes("Bastion", "", R.drawable.bastion));
        heroes.add(new Personajes("Genji", "", R.drawable.genji));
        heroes.add(new Personajes("Hanzo", "", R.drawable.hanzo));
        heroes.add(new Personajes("Junkrat", "", R.drawable.junkrat));
        heroes.add(new Personajes("Mccree", "", R.drawable.mccree));
        heroes.add(new Personajes("Mei", "", R.drawable.mei));
        heroes.add(new Personajes("Pharah", "", R.drawable.pharah));

        return heroes.toArray(new Personajes[heroes.size()]);
    }


    Personajes[] charactersList;

}
