package com.example.watchlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {
    TextView movie_results;
    ListView lvitems;
    ArrayList<String> movieArray;
    String movie_title;

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

        lvitems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i("Movie Tapped: ", movieArray.get(position));

                movie_title = movieArray.get(position);

                MovieAsyncTask2 asyncTask2 = new MovieAsyncTask2(this);
                asyncTask2.execute(movie_title);

            }

        });



    }


    public void movieStartIntent2(ArrayList<String> movieData2) {

        Intent dataIntent = new Intent(this, View_Movie.class);
        dataIntent.putExtra("data", movieData2);

        Intent intent = new Intent(DataActivity.this, View_Movie.class);

        intent.putExtra("movie_title", movie_title);

        this.startActivity(dataIntent);

    }

}

