package com.example.watchlist;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieAsyncTask4 extends AsyncTask<String, Integer, String> {
    Context context;
    favorites Asynctask4;

    public MovieAsyncTask4(favorites Asynctask4) {
        this.Asynctask4 = Asynctask4;
        this.context = this.Asynctask4.getApplicationContext();

    }

    // Searching in API
    @Override
    protected String doInBackground(String... params) {
        return HttpRequestHelper2.downloadFromServer(params);
    }

    // After retrieving data
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        ArrayList<DataObject> movies = new ArrayList<>();

        try {

            JSONObject movie_data2 = new JSONObject(result);
            String plot, title, year, directors, actors, poster;

            plot = movie_data2.getString("Plot");
            title = movie_data2.getString("Title");
            year = movie_data2.getString("Year");
            directors = movie_data2.getString("Director");
            actors = movie_data2.getString("Actors");
            poster = movie_data2.getString("Poster");

            DataObject moviedata = new DataObject();

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

        this.Asynctask4.movieStartIntent(movies);
    }
}




