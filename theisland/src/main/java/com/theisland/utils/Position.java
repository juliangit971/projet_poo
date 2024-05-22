package com.theisland.utils;

public class Position {
    
    private Integer x;
    private Integer y;



    // Constructors

    /**
     * {@code Position} Constructor
     * {@code x = null ; y = null} 
     */
    public Position(){
        this.x = null;
        this.y = null;
    }

    /**
     * {@code Position} Constructor
     * @param x position
     * @param y position
     */
    public Position(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }


    // Getters & Setters


    public Integer getX() {
        return x;
    }
    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }
    public void setY(Integer y) {
        this.y = y;
    }
}
