package com.example.uca.favoritescharacters.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.uca.favoritescharacters.adapters.List_HeroesRecyclerViewAdapter;
import com.example.uca.favoritescharacters.model.Personajes;
import com.example.uca.favoritescharacters.R;

import java.util.ArrayList;

/**
 * Created by uca on 04-23-18.
 */

public class List_Fragment extends Fragment{

    private OnListFragmentInteractionListener interactionListener;
    private OnListFragmentInteractionIcon interactionIcon;


    private List_HeroesRecyclerViewAdapter heroesRecyclerViewAdapter;
    private ViewPager vp;
    private String type;
    private ArrayList<Personajes> charactersModels;
    private ArrayList<Personajes> charactersFavModels;

    private ImageView favoriteIcon;

    public List_Fragment(){ }

    public static List_Fragment newInstance(String type, ArrayList<Personajes> charactersModels) {
        List_Fragment fragment = new List_Fragment();
        Bundle args = new Bundle();
        args.putString("type", type);
        args.putParcelableArrayList(type, charactersModels);
        fragment.setArguments(args);
        return fragment;
    }

   @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if (getArguments() == null) {
            throw new RuntimeException("You must to send a dummyModels ");
        }
        charactersModels = getArguments().getParcelableArrayList("s0");
        charactersFavModels = getArguments().getParcelableArrayList("s1");
        type = (String) getArguments().getString("type");


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.from(container.getContext()).inflate(R.layout.tab1_main, container, false);
        Bundle args = new Bundle();
        Context ctx = rootView.getContext();
        RecyclerView recyclerView = (RecyclerView)rootView;
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
        vp = (ViewPager)getActivity().findViewById(R.id.viewpager);
        heroesRecyclerViewAdapter = new List_HeroesRecyclerViewAdapter(getList(), vp, interactionListener, interactionIcon);
        recyclerView.setAdapter(heroesRecyclerViewAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        //la actividad debe implementart OnListFragmentInteractionListener
        if(context instanceof OnListFragmentInteractionListener){
            interactionListener =  (OnListFragmentInteractionListener) context;
            interactionIcon = (OnListFragmentInteractionIcon)context;
        }else{
            throw new RuntimeException(context.toString() + "debe implementar OnlistFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach(){
        super.onDetach();
        interactionListener = null;
        interactionIcon = null;
    }

    private ArrayList<Personajes> getList(){
        ArrayList<Personajes> list;
        if(type == "s1"){
            return charactersFavModels;
        }else
            return charactersModels;

    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Personajes item);
    }

    public interface OnListFragmentInteractionIcon{
        void onListFragmentInteractionIcon(Personajes item, int position);
    }

}
