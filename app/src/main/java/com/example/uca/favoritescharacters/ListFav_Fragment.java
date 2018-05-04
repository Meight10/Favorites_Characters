package com.example.uca.favoritescharacters;


import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFav_Fragment extends Fragment {

    ViewPager vp;
    private ListFav_HeroesRecyclerViewAdapter heroesRecyclerViewAdapter;


    public ListFav_Fragment(){}




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.from(container.getContext()).inflate(R.layout.tab2_favorites, container, false);

        Context ctx = rootView.getContext();
        RecyclerView recyclerView = (RecyclerView)rootView;
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
        vp = (ViewPager)getActivity().findViewById(R.id.viewpager);
        heroesRecyclerViewAdapter = new ListFav_HeroesRecyclerViewAdapter(vp, MainActivity.charactersListModels1);
        recyclerView.setAdapter(heroesRecyclerViewAdapter);
        return rootView;
    }


}
