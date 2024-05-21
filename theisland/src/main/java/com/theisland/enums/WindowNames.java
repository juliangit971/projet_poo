package com.theisland.enums;

public enum WindowNames {


    // Default Window name
    DEFAULT("THE ISLAND"),

    // Intro Window
    INTRO("THE ISLAND - WELCOME"),
    
    // Game Windows
    PLATE("NETFLIP - GAME");


    
    private String windowName;

    private WindowNames(String windowName) {
        this.windowName = windowName;
    }
    
    public String getWindowName() {
        return windowName;
    }
}
