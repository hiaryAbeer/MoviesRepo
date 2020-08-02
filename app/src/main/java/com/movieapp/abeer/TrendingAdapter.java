package com.movieapp.abeer;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.movieapp.abeer.models.MovieModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder> {
    private Context context;
    private List<MovieModel> list;
    private String imageURL = "https://image.tmdb.org/t/p/w500";//(​https://image.tmdb.org/t/p/​w500/

    public TrendingAdapter(Context context, List<MovieModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TrendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_trending, parent, false);
        return new TrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingViewHolder holder, int position) {

        Log.e("image" , imageURL + list.get(position).getPosterPath());
        Uri uri = Uri.parse(imageURL + list.get(position).getPosterPath());//"https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
        holder.draweeView.setImageURI(uri);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TrendingViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView draweeView;

        public TrendingViewHolder(@NonNull View itemView) {
            super(itemView);
            draweeView = itemView.findViewById(R.id.raw_trending_image);
        }
    }
}
