package com.example.watchlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class View_Movie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__movie);

        Intent intent = getIntent();
        String final_movie = intent.getStringExtra("movie_title");

        TextView movie_data = (TextView) findViewById(R.id.movie_data);

        Log.i("final", final_movie);

        movie_data.setText(final_movie);
    }



}

