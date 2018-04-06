package com.faisal.retrofit_demo.ui.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.faisal.retrofit_demo.R;
import com.faisal.retrofit_demo.data.local.movie.Movie;
import com.faisal.retrofit_demo.utils.SelectedBundle;


public class MovieDetailsFragment extends Fragment implements SelectedBundle {

    TextView title;
    TextView releaseDate;
    TextView movieDescription;

    Movie moviea = new Movie();

    public MovieDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        title= (TextView) view.findViewById(R.id.title) ;
        releaseDate= (TextView) view.findViewById(R.id.releaseDate) ;
        movieDescription= (TextView) view.findViewById(R.id.description) ;
        title.setText(moviea.getTitle());
        releaseDate.setText(moviea.getReleaseDate());
        movieDescription.setText(moviea.getOverview());
        return view;
    }

    @Override
    public void onBundleSelect(Bundle bundle) {
        Movie movie = (Movie) bundle.getSerializable("value");
        moviea=movie;

    }
}
