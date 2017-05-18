package com.example.watchlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MovieAsyncTask2 extends AsyncTask<String, Integer, String> {
    Context context;
    DataActivity mainAct2;

    public MovieAsyncTask2(DataActivity view){
        this.mainAct2 = view;
        this.context = this.mainAct2.getApplicationContext();

    }

    // Before app searches in API
    @Override
    protected void onPreExecute() {
        Toast.makeText(context, "Retrieving the info!  ", Toast.LENGTH_SHORT).show();
    }

    // Searching in API
    @Override
    protected String doInBackground(String... params) {
        return HttpRequestHelper2.downloadFromServer(params);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ArrayList<DataObject> movies = new ArrayList<>();

        try {

            JSONObject movie_data2 = new JSONObject(result);
            String plot, title, year, directors, actors, poster;

            // get the needed strings from the JSON object
            plot = movie_data2.getString("Plot");
            title = movie_data2.getString("Title");
            year = movie_data2.getString("Year");
            directors = movie_data2.getString("Director");
            actors = movie_data2.getString("Actors");
            poster = movie_data2.getString("Poster");

            DataObject moviedata = new DataObject();

            // Set the variables in the object to the just gotten strings
            moviedata.setPlot(plot);
            moviedata.setTitle(title);
            moviedata.setYear(year);
            moviedata.setDirectors(directors);
            moviedata.setActors(actors);
            moviedata.setPoster(poster);

            movies.add(moviedata);

        }


        catch (JSONException e) {
            e.printStackTrace();

        }
        this.mainAct2.movieStartIntent2(movies);
    }
}




