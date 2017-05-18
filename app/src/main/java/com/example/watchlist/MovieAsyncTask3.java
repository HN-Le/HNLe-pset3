package com.example.watchlist;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MovieAsyncTask3 extends AsyncTask<String, Void, Bitmap> {

    ImageView poster_movie;

    public MovieAsyncTask3(ImageView main){

        this.poster_movie = main;

    }

    // Searching in API
    @Override
    protected Bitmap doInBackground(String... params) {

        // download image from the link in the DataObject
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
