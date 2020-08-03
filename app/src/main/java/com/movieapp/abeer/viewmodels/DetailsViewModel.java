package com.movieapp.abeer.viewmodels;

import com.movieapp.abeer.models.MovieDetailsModel;
import com.movieapp.abeer.repository.DetailsRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailsViewModel extends ViewModel {

    private MutableLiveData<MovieDetailsModel> detailsLiveData;

    public LiveData<MovieDetailsModel> getDetailsLiveData() {
        return detailsLiveData;
    }

    public void initialization(){
        if (detailsLiveData != null)
            return;

        detailsLiveData = DetailsRepository.getInstance().getMovieDetailsFromRepo();

    }

}
