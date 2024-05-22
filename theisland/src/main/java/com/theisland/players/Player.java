package com.theisland.players;

import java.util.List;

import com.theisland.pawns.PawnExplorer;
import com.theisland.pawns.enums.PawnExplorerColors;

public class Player {

    private Integer ID;
    private PawnExplorerColors color;
    private List<PawnExplorer> ownedExplorers;
    private List<PawnExplorer> savedExplorers;


    // Getters & Setters


    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }

    public PawnExplorerColors getColor() {
        return color;
    }
    public void setColor(PawnExplorerColors color) {
        this.color = color;
    }

    public List<PawnExplorer> getOwnedExplorers() {
        return ownedExplorers;
    }
    public void setOwnedExplorers(List<PawnExplorer> ownedExplorers) {
        this.ownedExplorers = ownedExplorers;
    }

    public List<PawnExplorer> getSavedExplorers() {
        return savedExplorers;
    }
    public void setSavedExplorers(List<PawnExplorer> savedExplorers) {
        this.savedExplorers = savedExplorers;
    }
}
