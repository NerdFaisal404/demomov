package com.faisal.retrofit_demo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.faisal.retrofit_demo.R;
import com.faisal.retrofit_demo.data.local.movie.Movie;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    TextView title;
    TextView releaseDate;
    TextView movieDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title= (TextView) findViewById(R.id.title) ;
        releaseDate= (TextView) findViewById(R.id.releaseDate) ;
        movieDescription= (TextView) findViewById(R.id.description) ;

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        Movie movie = (Movie) bundle.getSerializable("value");

        title.setText(movie.getTitle());
        releaseDate.setText(movie.getReleaseDate());
        movieDescription.setText(movie.getOverview());


    }
}
