package com.chutzpah.simplemovieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    public MovieAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    private ArrayList<Movie> movies = new ArrayList<>();

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup,false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movie movie = (Movie)getItem(i);
        viewHolder.bind(movie);
        return itemView;
    }

    private class ViewHolder{
        private TextView tvTitle;
        private TextView tvDescription;
        private TextView tvUserScore;
        private ImageView imgPhoto;

        ViewHolder(View view){
            tvTitle = view.findViewById(R.id.tv_title);
            tvDescription = view.findViewById(R.id.tv_description);
            tvUserScore = view.findViewById(R.id.tv_user_score);
        }

        void bind(Movie movie){
            tvTitle.setText(movie.getTitle());
            tvDescription.setText(movie.getDescription());
            tvUserScore.setText(movie.getUser_score());
            imgPhoto.setImageResource(movie.getPhoto());
        }

    }
}
