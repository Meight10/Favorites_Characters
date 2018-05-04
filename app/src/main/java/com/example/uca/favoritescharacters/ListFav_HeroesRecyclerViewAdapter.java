package com.example.uca.favoritescharacters;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListFav_HeroesRecyclerViewAdapter extends RecyclerView.Adapter<ListFav_HeroesRecyclerViewAdapter.ViewHolderPersonajesFav>{


    private ViewPager vp;
    private List<Personajes> favCharacteresList;

    public ListFav_HeroesRecyclerViewAdapter(ViewPager vp, List<Personajes>favCharacteresList){
        this.vp = vp;
        this.favCharacteresList = favCharacteresList;


    }

    @Override
    public ViewHolderPersonajesFav onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_list, parent, false);

        return new ViewHolderPersonajesFav(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderPersonajesFav holder, final int position) {
        holder.nombre.setText(favCharacteresList.get(position).getName());
        holder.descripcion.setText(favCharacteresList.get(position).getDescription());
        holder.foto.setImageResource(favCharacteresList.get(position).getImagen());
        if (favCharacteresList.get(position).getFavorite()) {
            holder.favoriteIcon.setImageResource(R.drawable.ic_launcher);
        } else {
            holder.favoriteIcon.setImageResource(R.drawable.ic_overwatchicon);
        }
        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.favoriteIcon.setImageResource(R.drawable.ic_overwatchicon);
                favCharacteresList.get(position).setFavorite(false);
                MainActivity.charactersListModels1.remove(favCharacteresList.get(position));
                vp.getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderPersonajesFav extends RecyclerView.ViewHolder {

        public final View view;
        public final TextView nombre, descripcion;
        public final ImageView foto;
        public final ImageView favoriteIcon;

        public ViewHolderPersonajesFav(View itemView) {
            super(itemView);

            view = itemView;
            nombre = (TextView) itemView.findViewById(R.id.tvNombre);
            descripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
            foto = (ImageView) itemView.findViewById(R.id.image_character);

            favoriteIcon = (ImageView) itemView.findViewById(R.id.ic_favorites);
        }
    }
}
