package com.theisland.pawns;

import java.util.List;

public class PawnBoat extends Pawn {

    private List<PawnExplorer> explorers;

    
    // Getters & Setters

    public List<PawnExplorer> getExplorers() {
        return explorers;
    }
    public void setExplorers(List<PawnExplorer> explorers) {
        this.explorers = explorers;
    }
}
