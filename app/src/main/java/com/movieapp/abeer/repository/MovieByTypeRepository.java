package com.movieapp.abeer.repository;

import android.util.Log;

import com.movieapp.abeer.JsonPlaceHolder;
import com.movieapp.abeer.MoviesByGenresAdapter;
import com.movieapp.abeer.RetrofitClass;
import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.models.MovieModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieByTypeRepository {

    private static MovieByTypeRepository instance;
    private JsonPlaceHolder jsonPlaceHolder;

    public static MovieByTypeRepository getInstance() {
        if (instance == null)
            instance = new MovieByTypeRepository();

        return instance;
    }

    public MovieByTypeRepository() {
        jsonPlaceHolder = RetrofitClass.cteateService(JsonPlaceHolder.class);
    }

    public MutableLiveData<BaseData> getMovieByTypeFromRepo(){
        MutableLiveData<BaseData> data = new MutableLiveData<>();
        jsonPlaceHolder.getMoviesByGenresData().enqueue(new Callback<BaseData>() {
            @Override
            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
                if (response.isSuccessful()) {
                  data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<BaseData> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
