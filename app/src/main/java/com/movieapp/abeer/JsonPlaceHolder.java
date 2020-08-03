package com.movieapp.abeer;

import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.models.GenresModel;
import com.movieapp.abeer.models.MovieDetailsModel;
import com.movieapp.abeer.models.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface JsonPlaceHolder {

    @GET("trending/all/day?api_key=f0dd213b514dd22fa6d7790fdae32949")
    Call<BaseData> getBaseData();

    @GET("genre/movie/list?api_key=f0dd213b514dd22fa6d7790fdae32949")
    Call<BaseData> getGenresData();

    @GET("discover/movie?api_key=f0dd213b514dd22fa6d7790fdae32949&page=1&with_genres=28")
    Call<BaseData> getMoviesByGenresData();

    @GET("movie/516486?api_key=f0dd213b514dd22fa6d7790fdae32949")
    Call<MovieDetailsModel> getMovieDetail();

    @GET("movie/516486/credits?api_key=f0dd213b514dd22fa6d7790fdae32949")
    Call<BaseData> getCast();
}
