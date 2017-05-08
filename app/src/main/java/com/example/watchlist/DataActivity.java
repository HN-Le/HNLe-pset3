package com.example.watchlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {
    TextView movie_results;
    ListView lvitems;
    ArrayList<String> movieArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        movie_results = (TextView) findViewById(R.id.movie_results);
        lvitems = (ListView) findViewById(R.id.lvitems);

        Bundle extras = getIntent().getExtras();
        movieArray = (ArrayList<String>) extras.getSerializable("data");

        makeMovieAdapter();
    }

    public void makeMovieAdapter(){
        ArrayAdapter arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, movieArray);

        lvitems = (ListView) findViewById(R.id.lvitems);
        assert lvitems != null;
        lvitems.setAdapter(arrayAdapter);
    }
}
