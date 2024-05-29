package com.theisland.utils;

public class Position {
    
    private int x;
    private int y;



    // Constructors

    /**
     * {@code Position} Constructor
     * {@code x = null ; y = null} 
     */
    public Position(){
        this.x = 0;
        this.y = 0;
    }

    /**
     * {@code Position} Constructor
     * @param x position
     * @param y position
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }


    // Getters & Setters


    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
