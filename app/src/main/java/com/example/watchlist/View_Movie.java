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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__movie);

        TextView movie_data = (TextView) findViewById(R.id.movie_data);
        TextView movie_data_title = (TextView) findViewById(R.id.movie_data_title);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> data = new ArrayList<>();

        if (extras != null)
            data = extras.getStringArrayList("data");


        String result = data.get(0);
        String title = data.get(1);


        movie_data.setText(result);
        movie_data_title.setText(title);



    }



}

