package com.theisland.pawns;

import com.theisland.enums.GameElementStatusNames;
import com.theisland.gameelements.BoardSlot;

abstract public class Pawn {

    /**
     * Know if the player is saved or not
     * If {@code status == null}, the {@code Pawn} never has been used yet
     */
    private GameElementStatusNames status;
    private BoardSlot currentBoardSlot;


    // Getters & Setters


    public GameElementStatusNames getStatus() {
        return status;
    }
    public void setStatus(GameElementStatusNames status) {
        this.status = status;
    }

    public BoardSlot getCurrentBoardSlot() {
        return currentBoardSlot;
    }
    public void setCurrentBoardSlot(BoardSlot currentBoardSlot) {
        this.currentBoardSlot = currentBoardSlot;
    }
}
