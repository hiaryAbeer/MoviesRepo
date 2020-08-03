package com.movieapp.abeer.repository;

import com.movieapp.abeer.JsonPlaceHolder;
import com.movieapp.abeer.RetrofitClass;
import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TrendingRepository {

    private static TrendingRepository instance;
    private JsonPlaceHolder jsonPlaceHolder;

    public static TrendingRepository getInstance() {
        if (instance == null) {
            instance = new TrendingRepository();
        }
        return instance;
    }

    public TrendingRepository() {
        jsonPlaceHolder = RetrofitClass.cteateService(JsonPlaceHolder.class);

    }

    public MutableLiveData<BaseData> getTrendingRepo(){
        MutableLiveData<BaseData> data = new MutableLiveData<>();//MutableLiveData<List<MovieModel>> data = new MutableLiveData<>();

        jsonPlaceHolder.getBaseData().enqueue(new Callback<BaseData>() {
            @Override
            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
                if (response.isSuccessful()){
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
