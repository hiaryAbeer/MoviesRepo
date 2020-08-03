package com.movieapp.abeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Retrofit;

import android.os.Bundle;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.material.tabs.TabLayout;
import com.movieapp.abeer.databinding.ActivityMoviesBinding;
import com.movieapp.abeer.models.GenresModel;
import com.movieapp.abeer.models.MovieModel;
import com.movieapp.abeer.viewmodels.GenresViewModel;
import com.movieapp.abeer.viewmodels.TrendingViewModel;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

//    private RecyclerView trendingRecyclerView;
    private TrendingAdapter trendingAdapter;

//    private ViewPager viewPager;
//    private List<String> genresModelList = new ArrayList<>();
    private TabAdapter tabAdapter;
//    private TabLayout tabs;

    private TrendingViewModel trendingViewModel;
    private GenresViewModel genresViewModel;

    private List<MovieModel> trendingData = new ArrayList<>();
    private List<GenresModel> genresData = new ArrayList<>();
    private ActivityMoviesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies);

//        trendingRecyclerView = findViewById(R.id.recyclerView_trending);
//        viewPager = findViewById(R.id.movies_genres_vp);
//        tabs = findViewById(R.id.tabs);
        binding.tabs.setupWithViewPager(binding.moviesGenresVp);
        trendingAdapter = new TrendingAdapter(MoviesActivity.this, trendingData);

        getTrendingData();
        getGenresData();

    }

    void getTrendingData() {
        trendingViewModel = ViewModelProviders.of(this).get(TrendingViewModel.class);
        trendingViewModel.initialization();
        trendingViewModel.getmMovieModels().observe(this, response -> {
            trendingData = response.getList();
            Log.e("observelist", "" + trendingData.size());
//            articleArrayList.addAll(newsArticles);
//            trendingAdapter.notifyDataSetChanged();

            binding.recyclerViewTrending.setLayoutManager(new LinearLayoutManager(MoviesActivity.this, RecyclerView.HORIZONTAL, true));
            trendingAdapter = new TrendingAdapter(MoviesActivity.this, trendingData);
            binding.recyclerViewTrending.setAdapter(trendingAdapter);
        });
    }

    void getGenresData() {
        genresViewModel = ViewModelProviders.of(this).get(GenresViewModel.class);
        genresViewModel.initialization();
        genresViewModel.getGenresLiveData().observe(this, response -> {
            genresData = response.getGenresModelList();
            Log.e("observelist", "" + trendingData.size());

//            for (GenresModel genresModel : genresData) {
//                genresModelList.add(genresModel.getName());
//            }
            tabAdapter = new TabAdapter(MoviesActivity.this, getSupportFragmentManager(), genresData);
            binding.moviesGenresVp.setAdapter(tabAdapter);

        });
    }

}