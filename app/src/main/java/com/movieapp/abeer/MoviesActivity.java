package com.movieapp.abeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.material.tabs.TabLayout;
import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.models.GenresModel;
import com.movieapp.abeer.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private RecyclerView trendingRecyclerView;
    private TrendingAdapter trendingAdapter;

    private ViewPager viewPager;
    private JsonPlaceHolder jsonPlaceHolder;
    private List<String> genresModelList = new ArrayList<>();
    private TabAdapter tabAdapter;
    private TabLayout tabs;
    private Retrofit retrofit;

    //    DemoCollectionPagerAdapter demoCollectionPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);

        setContentView(R.layout.activity_movies);

        trendingRecyclerView = findViewById(R.id.recyclerView_trending);
//        tabAdapter = new TabAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.movies_genres_vp);
//        viewPager.setAdapter(tabAdapter);

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        getTendingRequest();
        getGenresTypeRequest();


    }

    void getTendingRequest() {
        Call<BaseData> call = jsonPlaceHolder.getBaseData();
        call.enqueue(new Callback<BaseData>() {
            @Override
            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
//                Toast.makeText(MoviesActivity.this, "success", Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    List<MovieModel> model = response.body().getList();
//                    Log.e("cccc", " " + model.size());

//                    for (MovieModel model1 : model) {
//                    Log.e("model", "" + model1.getOriginalTitle());
//                    }
                    trendingRecyclerView.setLayoutManager(new LinearLayoutManager(MoviesActivity.this, RecyclerView.HORIZONTAL, true));
                    trendingAdapter = new TrendingAdapter(MoviesActivity.this, model);
                    trendingRecyclerView.setAdapter(trendingAdapter);
                }
            }

            @Override
            public void onFailure(Call<BaseData> call, Throwable t) {
                Toast.makeText(MoviesActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("getTendingRequest/e", t.getMessage());

            }
        });

    }

    void getGenresTypeRequest() {
        Call<BaseData> genresModelCall = jsonPlaceHolder.getGenresData();
        genresModelCall.enqueue(new Callback<BaseData>() {
            @Override
            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
                if (response.isSuccessful()) {
                    genresModelList.clear();
                    List<GenresModel> list = response.body().getGenresModelList();
                    for (GenresModel genresModel : list) {
//                        Log.e("showtitile", genresModel.getName());
                        genresModelList.add(genresModel.getName());
                    }

                    tabAdapter = new TabAdapter(MoviesActivity.this, getSupportFragmentManager(), genresModelList);
                    viewPager.setAdapter(tabAdapter);
                }

            }

            @Override
            public void onFailure(Call<BaseData> call, Throwable t) {
                Log.e("getGenresTypeRequest/e", t.getMessage());

            }
        });

    }
}