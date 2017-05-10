package com.example.watchlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class View_Movie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__movie);

        TextView movie_data = (TextView) findViewById(R.id.movie_data);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> data = new ArrayList<>();

        if (extras != null)
            data = extras.getStringArrayList("data");

        String result = "";

        // Go over every list in array list
        for (String str : data){
            result += str + '\n';
        }

        movie_data.setText(result);



    }



}

