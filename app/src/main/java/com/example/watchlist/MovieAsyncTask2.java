package com.example.watchlist;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieAsyncTask2 extends AsyncTask<String, Integer, String> {
    Context context;
    DataActivity mainAct2;
    ArrayList<DataObject> movies;

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
        Log.i("PARAAAMSSS", params[0]);
        return HttpRequestHelper2.downloadFromServer(params);
    }

    // After retrieving data
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ArrayList<DataObject> movies = new ArrayList<>();

        Log.d("plot", "PLOOOOOOT");

        try {

            JSONObject movie_data2 = new JSONObject(result);
            String plot, title, year, directors, actors;

            plot = movie_data2.getString("Plot");
            title = movie_data2.getString("Title");
            year = movie_data2.getString("Year");
            directors = movie_data2.getString("Director");
            actors = movie_data2.getString("Actors");

            DataObject moviedata = new DataObject();

            moviedata.setPlot(plot);
            moviedata.setTitle(title);
            moviedata.setYear(year);
            moviedata.setDirectors(directors);
            moviedata.setActors(actors);

            movies.add(moviedata);


        }


        catch (JSONException e) {

            Log.d("plot", "ERRROR ");
            e.printStackTrace();

        }


        this.mainAct2.movieStartIntent2(movies);
    }




    }

