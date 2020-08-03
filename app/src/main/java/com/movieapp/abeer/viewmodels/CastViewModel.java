package com.movieapp.abeer.viewmodels;

import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.models.MovieDetailsModel;
import com.movieapp.abeer.repository.CastRepository;
import com.movieapp.abeer.repository.DetailsRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CastViewModel extends ViewModel {

    private MutableLiveData<BaseData> castLiveData;

    public LiveData<BaseData> getCastLiveData() {
        return castLiveData;
    }

    public void initialization(){
        if (castLiveData != null)
            return;

        castLiveData = CastRepository.getInstance().geCastFromRepo();

    }

}
