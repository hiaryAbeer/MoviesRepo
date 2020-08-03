package com.movieapp.abeer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.models.MovieModel;
import com.movieapp.abeer.viewmodels.MovieByTypeViewModel;
import com.movieapp.abeer.viewmodels.TrendingViewModel;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private RecyclerView recyclerView;
    private MovieByTypeViewModel movieByTypeViewModel;
    private List<MovieModel> list;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        Log.e("getArguments", "" + index);
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = root.findViewById(R.id.recyclerView_moviesByGenres);
        recyclerView.setLayoutManager(new GridLayoutManager(container.getContext(), 2));
        getMoviesByTypeRequest();

        return root;
    }

    void getMoviesByTypeRequest() {

        movieByTypeViewModel = ViewModelProviders.of(this).get(MovieByTypeViewModel.class);
        movieByTypeViewModel.initialization();
        movieByTypeViewModel.getMovieByTypeLiveData().observe(this, response -> {
                list = response.getList();

            MoviesByGenresAdapter moviesAdapter = new MoviesByGenresAdapter(getContext(), list);
                    recyclerView.setAdapter(moviesAdapter);
            });

//        JsonPlaceHolder jsonPlaceHolder;
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
//        Call<BaseData> call = jsonPlaceHolder.getMoviesByGenresData();
//        call.enqueue(new Callback<BaseData>() {
//            @Override
//            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
////                Toast.makeText(MoviesActivity.this, "success", Toast.LENGTH_SHORT).show();
//
//                if (response.isSuccessful()) {
//                    List<MovieModel> model = response.body().getList();
////                    Log.e("cccc", " " + model.size());
//
//                    for (MovieModel model1 : model) {
//                        Log.e("moviesByGenric", "" + model1.getOriginalTitle());
//                    }
//                    MoviesByGenresAdapter moviesAdapter = new MoviesByGenresAdapter(getContext(), model);
//                    recyclerView.setAdapter(moviesAdapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseData> call, Throwable t) {
////                Toast.makeText(MoviesActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("dddd", t.getMessage());
//
//            }
//        });

    }
}