package com.example.watchlist;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Tiny on 19-4-2017.
 */



public class MovieAsyncTask extends AsyncTask<String, Integer, String> {
    Context context;
    MainActivity mainAct;
    String data;
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
        ArrayList<String> list = new ArrayList<>();

        try {

            data = "";

            JSONObject movieStreamObject = new JSONObject(result);

            movie_data = movieStreamObject.optJSONArray("Search");

            String title = "";


            for(int i = 0; i < movie_data.length(); i++){

                JSONObject object = movie_data.getJSONObject(i);
                title = object.getString("Title");
                list.add(title);

                Log.i("title", title);

            }

            Log.i("result", result);




        } catch (JSONException e) {
            e.printStackTrace();
        }

        this.mainAct.movieStartIntent(list);
    }
}
