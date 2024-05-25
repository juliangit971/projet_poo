package com.theisland.enums;

import java.awt.Image;
import java.net.URL;

import com.theisland.utils.FileManager;

public enum ImagePaths {

    // System Window Layout
    WINDOW_ICON("gui/favico.png"),

    // Main Layout pictures
    TEST("gui/test.png"),
    GAME_SPLASH("gui/splash.png"),

    // Game Elements
    GAME_MAP("gui/map_rectified.png");

    private String imagePath;

    private ImagePaths(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public URL getImagePath() {
        return getClass().getClassLoader().getResource(imagePath);
    }


    /**
     * Return an {@ Image} Object in order to use it directly as a background image for a JPanel
     * @return an {@ Image} Object
     */
    public Image getImageForPanelBGImage() {
        FileManager fm = new FileManager();
        return fm.getImageFromLocalRes(getImagePath()); 
    }
}
