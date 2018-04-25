package com.example.uca.favoritescharacters;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by uca on 04-23-18.
 */

public class Personajes implements Parcelable{

    private String name;
    private String description;

    private int imagen;

    public Personajes(String name, String description, int imagen) {
        this.name = name;
        this.description = description;
        this.imagen = imagen;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
