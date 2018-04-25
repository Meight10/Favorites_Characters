package com.example.uca.favoritescharacters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class List_HeroesRecyclerViewAdapter extends RecyclerView.Adapter<List_HeroesRecyclerViewAdapter.ViewHolderPersonajes>{

    private final Personajes [] listaPersonajes;
    private final List_Fragment.OnListFragmentInteractionListener interactionListener;

    public List_HeroesRecyclerViewAdapter(Personajes[] listaPersonajes, List_Fragment.OnListFragmentInteractionListener interactionListener) {
        this.listaPersonajes = listaPersonajes;
        this.interactionListener = interactionListener;
    }

    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_main, null, false);
        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderPersonajes holder, int position) {
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


    }

    @Override
    public int getItemCount() {
        return listaPersonajes.length;
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {

        public Personajes heroeItem;
        public final View view;
        public final TextView nombre, descripcion;
        public final ImageView foto;


        public ViewHolderPersonajes(View itemView) {
            super(itemView);

            view = itemView;
            nombre = (TextView) itemView.findViewById(R.id.tvNombre);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
            foto = (ImageView) itemView.findViewById(R.id.imagen);
        }
    }
}
