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

/**
 * Created by Tiny on 19-4-2017.
 */

public class MovieAsyncTask2 extends AsyncTask<String, Integer, String> {
    Context context;
    DataActivity mainAct2;
    JSONArray movie_data2;

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
        return HttpRequestHelper.downloadFromServer(params);
    }

    // After retrieving data
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        ArrayList<String> data = new ArrayList<>();

        try {

            JSONObject movieStreamObject = new JSONObject(result);

            movie_data2 = movieStreamObject.optJSONArray("Search");

            String year;

            for(int i = 0; i < movie_data2.length(); i++){

                JSONObject object = movie_data2.getJSONObject(i);
                year = object.getString("Year");

                data.add(year);

                Log.i("year", year);
            }

            Log.i("result", result);

        }

        catch (JSONException e) {
            e.printStackTrace();
        }

        this.mainAct2.movieStartIntent2(data);
    }
}
