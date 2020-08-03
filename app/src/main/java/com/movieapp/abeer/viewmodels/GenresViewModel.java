package com.movieapp.abeer.viewmodels;

import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.repository.GenresRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GenresViewModel extends ViewModel {

    private MutableLiveData<BaseData> genresLiveData;

    public LiveData<BaseData> getGenresLiveData() {
        return genresLiveData;
    }

    public void initialization(){
        if (genresLiveData != null)
            return;

        genresLiveData = GenresRepository.getInstance().getGenresFromRepo();

    }
}
