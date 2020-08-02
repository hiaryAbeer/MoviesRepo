package com.movieapp.abeer;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.movieapp.abeer.models.MovieModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesByGenresAdapter  extends RecyclerView.Adapter<MoviesByGenresAdapter.GenresMovieViewHolder> {
    private Context context;
    private List<MovieModel> list;
    private String imageURL = "https://image.tmdb.org/t/p/w500";//(​https://image.tmdb.org/t/p/​w500/

    public MoviesByGenresAdapter(Context context, List<MovieModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public GenresMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_movies_by_genres, parent, false);
        return new GenresMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenresMovieViewHolder holder, int position) {

        Log.e("image" , imageURL + list.get(position).getPosterPath());
        Uri uri = Uri.parse(imageURL + list.get(position).getPosterPath());//"https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
        holder.movieImage.setImageURI(uri);

        holder.name.setText(list.get(position).getOriginalTitle());
        holder.rate.setText("" + list.get(position).getVoteAverage());
        holder.popularity.setText("" + list.get(position).getPopularity() + " Review");
//        holder.name.setText(list.get(position).getOriginalTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GenresMovieViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView movieImage;
        TextView name, type, popularity, rate;

        public GenresMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.raw_movies_movie);
            rate = itemView.findViewById(R.id.raw_movies_rate);
            name = itemView.findViewById(R.id.raw_movies_name);
            type = itemView.findViewById(R.id.raw_movies_type);
            popularity = itemView.findViewById(R.id.raw_movies_review);

        }
    }
}
