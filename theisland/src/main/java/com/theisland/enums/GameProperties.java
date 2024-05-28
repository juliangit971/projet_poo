package com.theisland.enums;

public enum GameProperties {

    MAX_PLAYERS("4");

    
    private String gameProperty;

    private GameProperties(String gameProperty) {
        this.gameProperty = gameProperty;
    }
    
    public String getGameProperty() {
        return gameProperty;
    }
}
