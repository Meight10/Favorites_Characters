package com.example.uca.favoritescharacters;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class List_HeroesRecyclerViewAdapter extends RecyclerView.Adapter<List_HeroesRecyclerViewAdapter.ViewHolderPersonajes>{

    private final List_Fragment.OnListFragmentInteractionListener interactionListener;
    private final List_Fragment.OnListFragmentInteractionIcon interactionIcon;

    private ArrayList<Personajes> characterList;
    private ViewPager viewPager;


    public List_HeroesRecyclerViewAdapter(ArrayList<Personajes> characterList, ViewPager viewPager, List_Fragment.OnListFragmentInteractionListener interactionListener,
    List_Fragment.OnListFragmentInteractionIcon interactionIcon) {
        this.characterList = characterList;
        this.viewPager = viewPager;
        this.interactionListener = interactionListener;
        this.interactionIcon = interactionIcon;

    }


    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_list, parent, false);

        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderPersonajes holder, final int position) {
       holder.nombre.setText(characterList.get(position).getName());
       holder.descripcion.setText(characterList.get(position).getDescription());
       holder.foto.setImageResource(characterList.get(position).getImagen());

        if (characterList.get(position).getFavorite()) {
            holder.favoriteIcon.setImageResource(R.drawable.ic_launcher);
        } else {
            holder.favoriteIcon.setImageResource(R.drawable.ic_overwatchicon);
        }


       holder.view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (null != interactionListener) {
                   interactionListener.onListFragmentInteraction(characterList.get(position));
               }
           }
       });

       holder.favoriteIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("InteractionIconEvent" + position + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                interactionIcon.onListFragmentInteractionIcon(characterList.get(position), position);
            }
       });

    }

    @Override
    public int getItemCount() {
        return characterList.size();
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
