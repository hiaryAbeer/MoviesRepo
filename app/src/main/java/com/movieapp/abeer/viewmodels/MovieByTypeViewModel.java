package com.movieapp.abeer.viewmodels;

import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.repository.GenresRepository;
import com.movieapp.abeer.repository.MovieByTypeRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MovieByTypeViewModel extends ViewModel {

    private MutableLiveData<BaseData> movieByTypeLiveData;

    public LiveData<BaseData> getMovieByTypeLiveData() {
        return movieByTypeLiveData;
    }

    public void initialization(){
        if (movieByTypeLiveData != null)
            return;

        movieByTypeLiveData = MovieByTypeRepository.getInstance().getMovieByTypeFromRepo();

    }
}
