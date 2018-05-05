package com.example.uca.favoritescharacters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by uca on 04-23-18.
 */

public class List_Fragment extends Fragment{

    private static final String KEY_MODEL = "KEY_MODEL";

    //private Personajes[] charactersModels;
    private OnListFragmentInteractionListener interactionListener;
    private List_HeroesRecyclerViewAdapter heroesRecyclerViewAdapter;
    private ViewPager vp;

    private ImageView favoriteIcon;

    public void setFavoriteIcon(ImageView favoriteIcon){
        this.favoriteIcon = favoriteIcon;
    }

    public ImageView getFavoriteIcon(){
        return favoriteIcon;
    }

    public List_Fragment(){ }

    /*public static List_Fragment newInstance(Personajes[] charactersModels) {
        List_Fragment fragment = new List_Fragment();
        Bundle args = new Bundle();
        args.putParcelableArray(KEY_MODEL, charactersModels);
        fragment.setArguments(args);
        return fragment;
    }*/

   /*@Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        if (getArguments() == null) {
            throw new RuntimeException("You must to send a dummyModels ");
        }
        charactersModels = (Personajes[]) getArguments().getParcelableArray(KEY_MODEL);


    }*/

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.from(container.getContext()).inflate(R.layout.tab1_main, container, false);
        Bundle args = new Bundle();
        Context ctx = rootView.getContext();
        RecyclerView recyclerView = (RecyclerView)rootView;
        recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
        vp = (ViewPager)getActivity().findViewById(R.id.viewpager);
        heroesRecyclerViewAdapter = new List_HeroesRecyclerViewAdapter(vp, interactionListener);
        recyclerView.setAdapter(heroesRecyclerViewAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        //la actividad debe implementart OnListFragmentInteractionListener
        if(context instanceof OnListFragmentInteractionListener){
            interactionListener =  (OnListFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString() + "debe implementar OnlistFragmentInteractionListener");
        }

    }

    @Override
    public void onDetach(){
        super.onDetach();
        interactionListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Personajes item);
    }


}
