package com.theisland.pawns.enums;

public enum PawnExplorerColors {
    
    RED("Rouge"),
    BLUE("Bleu"),
    YELLOW("Jaune"),
    GREEN("Vert");


    private String pawnExplorerColor;

    private PawnExplorerColors(String pawnExplorerColor) {
        this.pawnExplorerColor = pawnExplorerColor;
    }
    
    public String getIconPath() {
        return pawnExplorerColor;
    }
}
