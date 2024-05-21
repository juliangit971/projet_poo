package com.theisland.enums;

import java.net.URL;

public enum ImagePaths {

    // System Window Layout
    WINDOW_ICON("gui/the_island_icon.png"),

    // Main Layout pictures
    TEST("gui/test.png");


    private String imagePath;

    private ImagePaths(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public URL getIconPath() {
        return getClass().getClassLoader().getResource(imagePath);
    }
}
