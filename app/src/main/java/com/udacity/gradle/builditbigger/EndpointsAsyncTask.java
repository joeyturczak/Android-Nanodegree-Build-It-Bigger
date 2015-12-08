package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.joeyturczak.myapplication.backend.myJokeApi.MyJokeApi;

import java.io.IOException;

/**
 * Created by joeyturczak on 9/29/15.
 * Copyright (C) 2015 Joey Turczak
 */
class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyJokeApi myApiService = null;

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyJokeApi.Builder builder = new MyJokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-1084.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
