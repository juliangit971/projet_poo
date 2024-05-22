package com.theisland.enums;


/**
 * Allow us to know if an element of the game is on or off the board
 */
public enum GameElementStatusNames {

    ON_BOARD("Sur le plateau"),
    OFF_BOARD("Hors du plateau");


    private String gameElementStatusName;

    private GameElementStatusNames(String gameElementStatusName) {
        this.gameElementStatusName = gameElementStatusName;
    }
    
    public String getIconPath() {
        return gameElementStatusName;
    }
}
