package com.faisal.retrofit_demo.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.faisal.retrofit_demo.R;
import com.faisal.retrofit_demo.base.BaseAdapter;
import com.faisal.retrofit_demo.base.BaseViewHolder;
import com.faisal.retrofit_demo.data.local.movie.Movie;

import java.util.List;


public class MoviesAdapter1 extends BaseAdapter<Movie> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;


   /* public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }*/

    public MoviesAdapter1(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public boolean isEqual(Movie left, Movie right) {
        return false;
    }

    @Override
    public BaseViewHolder newViewHolder(ViewGroup parent, int viewType) {
       /* View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);*/

       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return 0;
    }

    @Override
    protected Movie getObjForPosition(int position) {
        return null;
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


    @Override
    public MoviesAdapter1.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


   /* @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());


    }*/

    @Override
    public void onBindViewHolder(BaseViewHolder<Movie> holder, int position) {
        super.onBindViewHolder(holder, position);
        Movie movie = getItem(position);
        if (movie == null) return;
        holder.bind(movie);
    }
    private class MovieViewHolder extends BaseViewHolder<Movie> implements View.OnClickListener {

        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View v) {
            super(v);

            v.setOnClickListener(this);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
        }

        @Override
        public void bind(Movie item) {

            if (item == null)
                return;
            // binding.setUser(item);
            // binding.executePendingBindings();



            movieTitle.setText(item.getTitle());
            data.setText(item.getReleaseDate());
            movieDescription.setText(item.getOverview());
            rating.setText(item.getVoteAverage().toString());

        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(view, getItem(getAdapterPosition()));
        }
    }
}