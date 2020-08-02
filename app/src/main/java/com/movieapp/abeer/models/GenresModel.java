package com.movieapp.abeer.models;

import com.google.gson.annotations.SerializedName;

public class GenresModel {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
