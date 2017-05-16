package com.example.watchlist;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.watchlist.R.id.poster_movie;

/**
 * Created by Tiny on 16-5-2017.
 */

public class MovieAsyncTask3 extends AsyncTask<String, Void, Bitmap> {

    ImageView poster_movie;

    public MovieAsyncTask3(ImageView main){

        this.poster_movie = main;

    }

    // Searching in API
    @Override
    protected Bitmap doInBackground(String... params) {

        URL url = null;

        try {
            url = new URL(params[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Bitmap bmp = null;
        try {
            assert url != null;
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bmp;
    }

    // After retrieving data
    @Override
    protected void onPostExecute(Bitmap bmp) {
        super.onPostExecute(bmp);
        poster_movie.setImageBitmap(bmp);

    }
}
