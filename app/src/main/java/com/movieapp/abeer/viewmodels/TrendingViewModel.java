package com.movieapp.abeer.viewmodels;

import android.util.Log;
import android.widget.Toast;

import com.movieapp.abeer.JsonPlaceHolder;
import com.movieapp.abeer.MoviesActivity;
import com.movieapp.abeer.TrendingAdapter;
import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.models.MovieModel;
import com.movieapp.abeer.repository.TrendingRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrendingViewModel extends ViewModel {

    private MutableLiveData<BaseData> mMovieModels;
    private TrendingRepository trendingRepository;

    public LiveData<BaseData> getmMovieModels() {
        return mMovieModels;
    }

    public void initialization() {
        if (mMovieModels != null)
            return;

        mMovieModels = TrendingRepository.getInstance().getTrendingRepo();
    }

}
