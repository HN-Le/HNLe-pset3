package com.example.watchlist;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestHelper2 {

    protected static synchronized String downloadFromServer(String... params) {
        String result = "";

        // the movie name from user input
        String chosenTag = params[0];

        Log.i("PARRAAAAAAAAMS", params[0]);
        URL site = null;
        String url;
        try {
            url = "http://www.omdbapi.com/?t=" + chosenTag;
            site = new URL(url);

        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection connect;

        try {
            // Initialize
            connect = (HttpURLConnection) site.openConnection();
            connect.setRequestMethod("GET");

            // Save response code, 200 is good more than 300 is bad
            Integer responseCode = connect.getResponseCode();

            if (responseCode >= 200 && responseCode < 300) {

                BufferedReader bReader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                String line;
                while ((line = bReader.readLine()) != null) {

                    result += line;
                }
            }
            Log.d("HTTP22222", result);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }
}
