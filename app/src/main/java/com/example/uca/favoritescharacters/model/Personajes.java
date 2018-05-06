package com.example.uca.favoritescharacters.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by uca on 04-23-18.
 */

public class Personajes implements Parcelable{

    private String name;
    private String description;

    private int imagen;

    private boolean favorite;

    public Personajes(String name, String description, int imagen, boolean favorite) {
        this.name = name;
        this.description = description;
        this.imagen = imagen;
        this.favorite = favorite;
    }

    public Personajes(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public boolean getFavorite(){return favorite;}

    public void setFavorite(boolean favorite){this.favorite = favorite;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
