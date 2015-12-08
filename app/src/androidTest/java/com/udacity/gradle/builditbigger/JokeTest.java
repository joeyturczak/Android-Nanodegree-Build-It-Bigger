package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by joeyturczak on 10/3/15.
 * Copyright (C) 2015 Joey Turczak
 */
public class JokeTest extends AndroidTestCase {
    public void testEndpointsAsyncTask() {
        try {
            assertNotSame("", new EndpointsAsyncTask().execute().get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
