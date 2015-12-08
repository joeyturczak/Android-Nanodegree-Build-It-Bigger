package com.joeyturczak.jokeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Copyright (C) 2015 Joey Turczak
 */

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "com.joeyturczak.EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = "";

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_JOKE)) {
            joke = intent.getStringExtra(EXTRA_JOKE);
        }

        TextView jokeTextView = (TextView) findViewById(R.id.joke_text_view);
        jokeTextView.setText(joke);
    }
}
