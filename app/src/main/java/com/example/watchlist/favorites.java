package com.example.watchlist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.watchlist.R.id.title;


public class favorites extends AppCompatActivity {

    ListView fav_movies;
    ArrayList<String> favorite_movies;
    String movie_title;
    private Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        fav_movies = (ListView) findViewById(R.id.fav_list);

        loadFromSharedPrefs();

        makeAdapter();

        fav_movies.setOnItemClickListener(new Listener());

    }

    public void loadFromSharedPrefs() {
        SharedPreferences prefs = this.getSharedPreferences("settings", this.MODE_PRIVATE);

        String favorites = prefs.getString("fav", null);

        if (favorites != null) {
            favorite_movies = new ArrayList<>(Arrays.asList(favorites.split(",")));

        }

    }

    public void makeAdapter(){
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, favorite_movies);

        assert fav_movies != null;
        fav_movies.setAdapter(arrayAdapter);
    }

    public void movieStartIntent(ArrayList<DataObject> movieData){
        Intent intent = new Intent(this, View_Movie.class);
        intent.putExtra("data", movieData);
        this.startActivity(intent);
    }

    private class Listener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick (AdapterView<?> parent, View view, int position, long id) {

            movie_title = favorite_movies.get(position);

            MovieAsyncTask4 asyncTask2 = new MovieAsyncTask4((favorites)context);

            try {
                asyncTask2.execute((URLEncoder.encode(movie_title, "UTF-8")));
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }

    }

}


