package com.example.uca.favoritescharacters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class List_HeroesRecyclerViewAdapter extends RecyclerView.Adapter<List_HeroesRecyclerViewAdapter.ViewHolderPersonajes>{

    ArrayList<Personajes> listaPersonajes;

    public List_HeroesRecyclerViewAdapter(ArrayList<Personajes> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_list, null, false);
        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderPersonajes holder, int position) {
        holder.nombre.setText(listaPersonajes.get(position).getName());
        holder.descripcion.setText(listaPersonajes.get(position).getDescription());
        holder.foto.setImageResource(listaPersonajes.get(position).getImagen());

    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {

        TextView nombre, descripcion;
        ImageView foto;


        public ViewHolderPersonajes(View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.tvNombre);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
            foto = (ImageView) itemView.findViewById(R.id.imagen);
        }
    }
}
