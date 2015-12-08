package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.*;
import com.google.android.gms.ads.InterstitialAd;

import java.util.concurrent.ExecutionException;

/**
 * Copyright (C) 2015 Joey Turczak
 */

public class MainActivity extends ActionBarActivity {

    public static final String ACTION_JOKE = "com.joeyturczak.action.JOKE";
    public static final String EXTRA_JOKE = "com.joeyturczak.EXTRA_JOKE";

    private InterstitialAd mInterstitialAd;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        //new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Manfred"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Loads interstitial ad when the Tell Joke button is clicked.
    public void tellJoke(View view){

        mProgressBar.setVisibility(View.VISIBLE);

        loadInterstitialAd();
    }

    // Creates interstitial ad
    private void loadInterstitialAd() {
        mInterstitialAd = new com.google.android.gms.ads.InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                Toast.makeText(getApplicationContext(), "Failed to load Ad", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                mInterstitialAd.show();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();

                String joke = null;
                try {
                    joke = new EndpointsAsyncTask().execute().get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }

                Intent jokeIntent = new Intent();
                jokeIntent.setAction(ACTION_JOKE);
                jokeIntent.putExtra(EXTRA_JOKE, joke);

                // Verify that the intent will resolve to an activity
                if (jokeIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(jokeIntent);
                } else {
                    Toast.makeText(getApplicationContext(), joke, Toast.LENGTH_SHORT).show();
                }
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(mProgressBar != null) {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }
}
