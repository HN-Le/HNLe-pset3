package com.example.watchlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie = (EditText) findViewById(R.id.movie);

        // Edit text should always be initialized
        assert movie != null;

    }

    public void movieSearch(View view){

        // Get user input
        String movieSearch = movie.getText().toString();

        // Search movie in database API
        // Perform async tasks. While retrieving data the app shouldn't freeze
        // Give it the present context
        MovieAsyncTask asyncTask = new MovieAsyncTask(this);

        // Using async task
        asyncTask.execute(movieSearch);
        movie.getText().clear();

    }

    public void movieStartIntent(ArrayList<String> movieData) {

        Intent dataIntent = new Intent(this, DataActivity.class);
        dataIntent.putExtra("data", movieData);
        this.startActivity(dataIntent);

    }

}
