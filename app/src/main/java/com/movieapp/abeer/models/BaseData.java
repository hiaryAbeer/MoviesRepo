package com.movieapp.abeer.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseData {

    @SerializedName("results")
    private List<MovieModel> list;

    public List<MovieModel> getList() {
        return list;
    }

    @SerializedName("genres")
    private List<GenresModel> genresModelList;

    public List<GenresModel> getGenresModelList() {
        return genresModelList;
    }

    @SerializedName("cast")
    private List<CastModel> castModels;

    public List<CastModel> getCastModels() {
        return castModels;
    }
}
