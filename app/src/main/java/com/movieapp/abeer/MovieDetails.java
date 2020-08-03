package com.movieapp.abeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.movieapp.abeer.databinding.ActivityMovieDetailsBinding;
import com.movieapp.abeer.models.BaseData;
import com.movieapp.abeer.models.CastModel;
import com.movieapp.abeer.models.MovieDetailsModel;
import com.movieapp.abeer.models.MovieModel;
import com.movieapp.abeer.viewmodels.CastViewModel;
import com.movieapp.abeer.viewmodels.DetailsViewModel;
import com.movieapp.abeer.viewmodels.MovieByTypeViewModel;

import java.util.List;

import static com.movieapp.abeer.MoviesByGenresAdapter.MOVIE_NAME;

public class MovieDetails extends AppCompatActivity {

    private MovieModel movieModel;
    //    private SimpleDraweeView simpleDraweeView;
    private TextView name, vote, overview, seen, type;
    private String imageURL = "https://image.tmdb.org/t/p/w500";
    //    private RecyclerView recyclerView;
    private CastAdapter castAdapter;
    private DetailsViewModel detailsViewModel;
    private MovieDetailsModel detailsModel = new MovieDetailsModel();
    private CastViewModel castViewModel;
    private ActivityMovieDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);

//        name = findViewById(R.id.details_name);
//        vote = findViewById(R.id.details_rate);
//        overview = findViewById(R.id.details_details);
//        seen = findViewById(R.id.details_seen);
//        simpleDraweeView = findViewById(R.id.details_simpleDraweeView);
//        type = findViewById(R.id.details_type);
//        recyclerView = findViewById(R.id.recyclerView_cast);
        binding.setDetailsModel(detailsModel);
        binding.recyclerViewCast.setLayoutManager(new LinearLayoutManager(MovieDetails.this, RecyclerView.HORIZONTAL, false));

        if (getIntent().getExtras() != null) {
            movieModel = (MovieModel) getIntent().getSerializableExtra(MOVIE_NAME);
            getMovieDetails();
        }

        getCastRequest();

    }

    void getMovieDetails() {

        detailsViewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        detailsViewModel.initialization();
        detailsViewModel.getDetailsLiveData().observe(this, response -> {
            detailsModel = response;
            binding.detailsName.setText(detailsModel.getName());
            binding.detailsRate.setText("" + detailsModel.getVote_average());
            binding.detailsDetails.setText(detailsModel.getOverview());
            binding.detailsSeen.setText("" + detailsModel.getPopularity());

            String genres = "";
            for (int i = 0; i < detailsModel.getGenresModelList().size(); i++)
                if (i + 1 == detailsModel.getGenresModelList().size())
                    genres += " " + detailsModel.getGenresModelList().get(i).getName() + " ";
                else
                    genres += " " + detailsModel.getGenresModelList().get(i).getName() + " / ";

            binding.detailsType.setText(genres);


            Uri uri = Uri.parse(imageURL + detailsModel.getMovieImage());//"https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
            binding.detailsSimpleDraweeView.setImageURI(uri);
        });

//
//        Call<MovieDetailsModel> call = jsonPlaceHolder.getMovieDetail();
//        call.enqueue(new Callback<MovieDetailsModel>() {
//            @Override
//            public void onResponse(Call<MovieDetailsModel> call, Response<MovieDetailsModel> response) {
////                Toast.makeText(MoviesActivity.this, "success", Toast.LENGTH_SHORT).show();
//
//                if (response.isSuccessful()) {
//                    MovieDetailsModel detailsModel = response.body();
//                    Log.e("moviedetails/", "" + detailsModel.getVote_average());
//                    name.setText(detailsModel.getName());
//                    vote.setText("" + detailsModel.getVote_average());
//                    seen.setText("" + detailsModel.getPopularity());
//                    overview.setText("" + detailsModel.getOverview());
//                    String genres = "";
//                    for (int i = 0; i < detailsModel.getGenresModelList().size(); i++)
//                        if (i + 1 == detailsModel.getGenresModelList().size())
//                            genres += " " + detailsModel.getGenresModelList().get(i).getName() + " ";
//                        else
//                            genres += " " + detailsModel.getGenresModelList().get(i).getName() + " / ";
//
//                    type.setText("" + genres);
//
//                    Uri uri = Uri.parse(imageURL + detailsModel.getMovieImage());//"https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
//                    simpleDraweeView.setImageURI(uri);
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieDetailsModel> call, Throwable t) {
//                Toast.makeText(MovieDetails.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("movieDetails/e", t.getMessage());
//
//            }
//        });
    }

    void getCastRequest() {

        castViewModel = ViewModelProviders.of(this).get(CastViewModel.class);
        castViewModel.initialization();
        castViewModel.getCastLiveData().observe(this, response -> {
            List<CastModel> model = response.getCastModels();

            castAdapter = new CastAdapter(MovieDetails.this, model);
            binding.recyclerViewCast.setAdapter(castAdapter);
        });
//        Call<BaseData> call = jsonPlaceHolder.getCast();
//        call.enqueue(new Callback<BaseData>() {
//            @Override
//            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
//
//                Log.e("cast", " " + response.body());
////                Toast.makeText(MoviesActivity.this, "success", Toast.LENGTH_SHORT).show();
//
//                if (response.isSuccessful()) {
//                    List<CastModel> model = response.body().getCastModels();
//                    Log.e("cast", " " + model.size());
//
////                    for (MovieModel model1 : model) {
////                    Log.e("model", "" + model1.getOriginalTitle());
////                    }
//                    castAdapter = new CastAdapter(MovieDetails.this, model);
//                    recyclerView.setAdapter(castAdapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseData> call, Throwable t) {
////                Toast.makeText(MovieDetails.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("cast/e", t.getMessage());
//
//            }
//        });

    }

}