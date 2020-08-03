package com.movieapp.abeer.repository;

import com.movieapp.abeer.JsonPlaceHolder;
import com.movieapp.abeer.RetrofitClass;
import com.movieapp.abeer.models.MovieDetailsModel;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsRepository {
    private static DetailsRepository instance;
    private JsonPlaceHolder jsonPlaceHolder;

    public static DetailsRepository getInstance() {
        if (instance == null)
            instance = new DetailsRepository();

        return instance;
    }

    public DetailsRepository() {
        jsonPlaceHolder = RetrofitClass.cteateService(JsonPlaceHolder.class);
    }

    public MutableLiveData<MovieDetailsModel> getMovieDetailsFromRepo(){
        MutableLiveData<MovieDetailsModel> data = new MutableLiveData<>();
        jsonPlaceHolder.getMovieDetail().enqueue(new Callback<MovieDetailsModel>() {
            @Override
            public void onResponse(Call<MovieDetailsModel> call, Response<MovieDetailsModel> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieDetailsModel> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
