package com.movieapp.abeer.repository;

import com.movieapp.abeer.JsonPlaceHolder;
import com.movieapp.abeer.RetrofitClass;
import com.movieapp.abeer.models.BaseData;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CastRepository {

    private static CastRepository instance;
    private JsonPlaceHolder jsonPlaceHolder;

    public static CastRepository getInstance() {
        if (instance == null)
            instance = new CastRepository();

        return instance;
    }

    public CastRepository() {
        jsonPlaceHolder = RetrofitClass.cteateService(JsonPlaceHolder.class);
    }

    public MutableLiveData<BaseData> geCastFromRepo() {

        MutableLiveData<BaseData> data = new MutableLiveData<>();
        jsonPlaceHolder.getCast().enqueue(new Callback<BaseData>() {
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
