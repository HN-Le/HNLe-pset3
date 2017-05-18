package com.example.watchlist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class View_Movie extends AppCompatActivity {

    String plot, title, year, directors, actors, poster, favorite_movie;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__movie);


        TextView movie_data = (TextView) findViewById(R.id.movie_data);
        TextView movie_data_title = (TextView) findViewById(R.id.movie_data_title);
        TextView movie_data_year = (TextView) findViewById(R.id.movie_data_year);
        TextView movie_data_directors = (TextView) findViewById(R.id.movie_data_directors);
        TextView movie_data_actors = (TextView) findViewById(R.id.movie_data_actors);
        ImageView poster_movie = (ImageView) findViewById(R.id.poster_movie);
        Button add_button = (Button) findViewById(R.id.add);

        ArrayList<DataObject> movieArray;
        Bundle extras = getIntent().getExtras();

        movieArray = (ArrayList<DataObject>) extras.getSerializable("data");

        if (movieArray != null) {

            for (DataObject movieobject : movieArray) {
                plot = movieobject.getPlot();
                title = movieobject.getTitle();
                year = movieobject.getYear();
                directors = movieobject.getDirectors();
                actors = movieobject.getActors();
                poster = movieobject.getPoster();

            }
        }

        if (poster.length() > 8) {
            MovieAsyncTask3 asyncTask3 = new MovieAsyncTask3(poster_movie);
            asyncTask3.execute(poster);
        }

        movie_data.setText("PLOT:\n" + plot);
        movie_data_title.setText(title);
        movie_data_year.setText("Year: " + year);
        movie_data_directors.setText("Directors: " + directors);
        movie_data_actors.setText("Actors: " + actors);


    }

    public void saveToSharedPrefs(View view) {

        loadFromSharedPrefs();
        SharedPreferences prefs = this.getSharedPreferences("settings", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        context = getApplicationContext();

        if (favorite_movie == null) {
            favorite_movie = title + ",";
            Toast.makeText(context, "Added!  ", Toast.LENGTH_SHORT).show();
        } else if (favorite_movie.contains(title)) {
            favorite_movie = favorite_movie.replace(title + ",", "");
            Toast.makeText(context, "Removed! ", Toast.LENGTH_SHORT).show();
        } else {
            favorite_movie = favorite_movie + title + ",";
            Toast.makeText(context, "Added!  ", Toast.LENGTH_SHORT).show();
        }

        editor.putString("fav", favorite_movie);
        editor.commit();
    }


    public void loadFromSharedPrefs() {
        SharedPreferences prefs = this.getSharedPreferences("settings", this.MODE_PRIVATE);

        String favorites = prefs.getString("fav", null);

        if (favorites != null) {
            favorite_movie = favorites;
        }

    }


    public void favs(View view) {
        Intent intent = new Intent(this, favorites.class);

        startActivity(intent);
        finish();
    }
}

