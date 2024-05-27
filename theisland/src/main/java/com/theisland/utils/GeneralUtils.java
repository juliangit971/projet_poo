package com.theisland.utils;

public class GeneralUtils {


    /**
     * Get a random number between a {@code min} and a {@code max}  
     * @param min the minimum possible to get
     * @param max the maximum possible to get
     * @return
     */
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
