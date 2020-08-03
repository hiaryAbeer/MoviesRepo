package com.movieapp.abeer.repository;

import com.movieapp.abeer.JsonPlaceHolder;
import com.movieapp.abeer.RetrofitClass;
import com.movieapp.abeer.models.BaseData;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenresRepository {

    private static GenresRepository instance;
    private JsonPlaceHolder jsonPlaceHolder;

    public static GenresRepository getInstance(){
        if (instance == null){
            instance = new GenresRepository();
        }
        return instance;
    }

    public GenresRepository() {
        jsonPlaceHolder = RetrofitClass.cteateService(JsonPlaceHolder.class);
    }

    public MutableLiveData<BaseData> getGenresFromRepo(){
        MutableLiveData<BaseData> data = new MutableLiveData<>();
        jsonPlaceHolder.getGenresData().enqueue(new Callback<BaseData>() {
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
