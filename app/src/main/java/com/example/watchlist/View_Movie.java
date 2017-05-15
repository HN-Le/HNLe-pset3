package com.example.watchlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class View_Movie extends AppCompatActivity {

//MovieAsyncTask2.DataObject moviedata;

    String plot, title, year, directors, actors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__movie);

        TextView movie_data = (TextView) findViewById(R.id.movie_data);
        TextView movie_data_title = (TextView) findViewById(R.id.movie_data_title);
        TextView movie_data_year = (TextView) findViewById(R.id.movie_data_year);
        TextView movie_data_directors = (TextView) findViewById(R.id.movie_data_directors);
        TextView movie_data_actors = (TextView) findViewById(R.id.movie_data_actors);

        ArrayList<DataObject> movieArray;

        Bundle extras = getIntent().getExtras();

        movieArray = (ArrayList<DataObject>) extras.getSerializable("data");

        if (movieArray != null){

            for (DataObject movieobject: movieArray) {
                plot = movieobject.getPlot();
                title = movieobject.getTitle();
                year = movieobject.getYear();
                directors = movieobject.getDirectors();
                actors = movieobject.getActors();


            }

        }

        movie_data.setText("PLOT:\n" + plot);
        movie_data_title.setText(title);
        movie_data_year.setText("Year: " + year );
        movie_data_directors.setText("Directors: " + directors );
        movie_data_actors.setText("Actors: " + actors);


    }



}

