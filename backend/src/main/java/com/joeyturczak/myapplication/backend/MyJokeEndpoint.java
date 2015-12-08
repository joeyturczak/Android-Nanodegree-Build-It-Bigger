package com.joeyturczak.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.joeyturczak.MyJokes;

/**
 * An endpoint class we are exposing
 * Copyright (C) 2015 Joey Turczak
 */
@Api(
        name = "myJokeApi",
        version = "v1",
        resource = "myJoke",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.joeyturczak.com",
                ownerName = "backend.myapplication.joeyturczak.com",
                packagePath = ""
        )
)
public class MyJokeEndpoint {

    @ApiMethod(name = "tellJoke")
    public MyJoke tellJoke() {

        MyJokes jokes = new MyJokes();
        String joke = jokes.getJoke();

        MyJoke response = new MyJoke();
        response.setJoke(joke);

        return response;
    }

}