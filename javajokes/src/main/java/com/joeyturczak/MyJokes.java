package com.joeyturczak;

import java.util.Random;

/**
 * Copyright (C) 2015 Joey Turczak
 */

public class MyJokes {

    private String[] mJokes = {
            "Why was 6 afraid of 7?\n\nBecause 7, 8, 9.",
            "What musical instrument is found in the bathroom?\n\nA tuba toothpaste.",
            "What do you call cheese that's not your cheese?\n\nNacho cheese!",
            "What do elves learn in school?\n\nThe elf-abet.",
            "Why did the boy bring a ladder to school?\n\nHe wanted to go to high school.",
            "Where do pencils go for vacation?\n\nPencil-vania.",
            "Why did the girl smear peanut butter on the road?\n\nTo go with the traffic jam!",
            "Why do bananas have to put on sunscreen before going to the beach?\n\nBecause they might peel!",
            "How do you make a tissue dance?\n\nYou put a little boogie in it.",
            "Which flower talks the most?\n\nTulips, of course, because they have two lips!",
            "Why couldn't the pony sing himself a lullaby?\n\nHe was a little hoarse.",
            "A skeleton walks into a bar and orders a drink and a mop",
            "Two peanuts are walking down the street and one was assaulted.",
            "How do you get an alien baby to sleep?\n\nYou rocket.",
            "Where does a penguin keep his money?\n\nIn a snow bank.",
            "What has no legs but can do a split?\n\nA banana!",
            "How do you communicate with a fish?\n\nYou drop it a line.",
            "What falls down but never gets hurt?\n\nSnow.",
            "What do you get if you cross a stereo and a refrigerator?\n\nVery cool music.",
            "Why couldn't the shoes go out and play?\n\nThey were all tied up!",
            "Why didn't the leopard go on vacation?\n\nIt couldn't find the right spot.",
            "What did the skunk say when the wind changed?\n\nIt all comes back to me now!",
            "Why do phones ring?\n\nBecause they can't talk!",
            "What is the biggest room in the world?\n\nRoom for improvement!",
            "What room can no one enter?\n\nA mushroom.",
            "What opens and shuts but is not a door or windows?\n\nYour mind!",
            "What is a parasite?\n\nSomething you see in Paris",
            "What do you get when you cross a pig with a christmas tree?\n\nA porcupine!",
            "When do you stop at green and go at red?\n\nWhen eating watermelon!",
            "What did the bee say to the flower?\n\nHi Bud! What time do you open?",
            "Why do hamburgers fly south for the winter?\n\nSo they won't freeze their buns!"

    };

    public String getJoke() {

        Random randomGenerator = new Random();
        int jokeNumber = randomGenerator.nextInt(mJokes.length);

        return mJokes[jokeNumber];
    }
}
