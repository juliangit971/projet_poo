package com.theisland.gameelements;

import java.util.List;

public class GameBoard {

    private List<BoardSlot> boardSlots;


    // Getters & Setters


    public List<BoardSlot> getBoardSlots() {
        return boardSlots;
    }
    public void setBoardSlots(List<BoardSlot> boardSlots) {
        this.boardSlots = boardSlots;
    }
}
