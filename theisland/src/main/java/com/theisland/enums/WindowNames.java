package com.theisland.enums;

public enum WindowNames {


    // Default Window
    DEFAULT("THE ISLAND"),

    // Main Menu Window
    MAIN_MENU(DEFAULT.getWindowName()),
    
    // Game Windows
    GAME("THE ISLAND - GAME MAP");


    
    private String windowName;

    private WindowNames(String windowName) {
        this.windowName = windowName;
    }
    
    public String getWindowName() {
        return windowName;
    }
}
