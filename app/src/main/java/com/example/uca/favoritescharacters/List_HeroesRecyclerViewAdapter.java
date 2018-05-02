package com.example.uca.favoritescharacters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class List_HeroesRecyclerViewAdapter extends RecyclerView.Adapter<List_HeroesRecyclerViewAdapter.ViewHolderPersonajes>{

    private final Personajes [] listaPersonajes;
    private final List_Fragment.OnListFragmentInteractionListener interactionListener;
    private MainActivity activity;
    static final String KEY_TITLE = "TITLE";
    private ViewPager viewPager;


    public List_HeroesRecyclerViewAdapter(ViewPager viewPager, Personajes[] listaPersonajes, List_Fragment.OnListFragmentInteractionListener interactionListener) {
        this.viewPager = viewPager;
        this.listaPersonajes = listaPersonajes;
        this.interactionListener = interactionListener;

    }




    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_list, null, false);

        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderPersonajes holder, final int position) {
       Personajes heroes = listaPersonajes[position];
       holder.heroeItem = heroes;
       holder.nombre.setText(heroes.getName());
       holder.descripcion.setText(heroes.getDescription());
       holder.foto.setImageResource(heroes.getImagen());



       holder.view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (null != interactionListener) {
                   // Notify the active callbacks interface (the activity, if the
                   // fragment is attached to one) that an item has been selected.
                   interactionListener.onListFragmentInteraction(holder.heroeItem);
               }
           }
       });

       holder.favoriteIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(listaPersonajes[position].getFavorite()){
                    holder.favoriteIcon.setImageResource(R.drawable.ic_overwatchicon);
                    MainActivity.charactersListModels1.remove(MainActivity.charactersListModels0[position]);
                    viewPager.getAdapter().notifyDataSetChanged();
                    MainActivity.charactersListModels0[position].setFavorite(false);
                }else{
                    holder.favoriteIcon.setImageResource(R.drawable.ic_launcher);
                    MainActivity.charactersListModels1.add(MainActivity.charactersListModels0[position]);
                    MainActivity.charactersListModels0[position].setFavorite(true);
                    viewPager.getAdapter().notifyDataSetChanged();
                }



            }
       });

    }

    @Override
    public int getItemCount() {
        return listaPersonajes.length;
    }

    public static class ViewHolderPersonajes extends RecyclerView.ViewHolder{

        public Personajes heroeItem;
        public final View view;
        public final TextView nombre, descripcion;
        public final ImageView foto;
        public final ImageView favoriteIcon;


        public ViewHolderPersonajes(View itemView) {
            super(itemView);

            view = itemView;
            nombre = (TextView) itemView.findViewById(R.id.tvNombre);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
            foto = (ImageView) itemView.findViewById(R.id.image_character);

            favoriteIcon = (ImageView) itemView.findViewById(R.id.ic_favorites);

        }

    }


}
