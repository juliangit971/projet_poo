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

    // [#] Game Elements

    // * General
    GAME_MAP("gui/map_rectified.png"),

    // * Tiles 
    TILE_BEACH("gui/tile_beach.png"),
    TILE_FOREST("gui/tile_forest.png"),
    TILE_MOUNTAIN("gui/tile_mountain.png"),

    // * Pawns

    // ** Pawn Explorer
    PAWN_EXPLORER_BLUE("gui/pawn_explorer_blue.png"),
    PAWN_EXPLORER_GREEN("gui/pawn_explorer_green.png"),
    PAWN_EXPLORER_RED("gui/pawn_explorer_red.png"),
    PAWN_EXPLORER_YELLOW("gui/pawn_explorer_yellow.png");


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
