package com.theisland.gameelements;

import java.util.ArrayList;
import java.util.List;

import com.theisland.pawns.Pawn;
import com.theisland.tiles.Tile;
import com.theisland.utils.JButtonHexagon;
import com.theisland.utils.Position;

public class BoardSlot {

    /**
     * If Tile == null : Slot is a Water Slot
    */
    private Tile tile;
    private List<Pawn> pawns;
    private JButtonHexagon hexagonButton;

    
    /*
     * To know in which row and line the Slot is
     */
    private Position position;


    public BoardSlot() {
        this.pawns = new ArrayList<>();
    }


    // Adders & Removers

    public void addPawn(Pawn pawn) {
        this.pawns.add(pawn);
    }

    public void removePawn(int index) {
        this.pawns.remove(index);
    }


    // Getters & Setters

    public Tile getTile() {
        return tile;
    }
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public List<Pawn> getPawns() {
        return pawns;
    }
    public void setPawns(List<Pawn> pawns) {
        this.pawns = pawns;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public JButtonHexagon getHexagonButton() {
        return hexagonButton;
    }
    public void setHexagonButton(JButtonHexagon hexagonButton) {
        this.hexagonButton = hexagonButton;
    }
}
