package com.example.watchlist;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieAsyncTask extends AsyncTask<String, Integer, String> {
    Context context;
    MainActivity mainAct;
    JSONArray movie_data;

    public MovieAsyncTask(MainActivity main){
        this.mainAct = main;
        this.context = this.mainAct.getApplicationContext();

    }

    // Before app searches in API
    @Override
    protected void onPreExecute() {
        Toast.makeText(context, "Searching for your movie!  ", Toast.LENGTH_SHORT).show();
    }

    // Searching in API
    @Override
    protected String doInBackground(String... params) {
        return HttpRequestHelper.downloadFromServer(params);
    }

    // After retrieving data
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ArrayList<String> data = new ArrayList<>();

        try {

            JSONObject movieStreamObject = new JSONObject(result);

            movie_data = movieStreamObject.optJSONArray("Search");

            if (movie_data != null) {

                String title;

                // loop through JSON object and get all the titles
                for (int i = 0; i < movie_data.length(); i++) {

                    JSONObject object = movie_data.getJSONObject(i);
                    title = object.getString("Title");

                    data.add(title);

                }

                this.mainAct.movieStartIntent(data);
            }

            // if input is nonsense and no search results are available
            else{
                Toast.makeText(context, "Invalid title! Please try again!", Toast.LENGTH_SHORT).show();
            }

        }

        catch (JSONException e) {
            e.printStackTrace();
            }


    }
}
