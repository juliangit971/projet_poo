package com.theisland.pawns;

import com.theisland.enums.GameElementStatusNames;
import com.theisland.gameelements.BoardSlot;
import com.theisland.pawns.enums.PawnExplorerColors;
import com.theisland.utils.Position;

abstract public class Pawn {

    private GameElementStatusNames status;
    private BoardSlot currentBoardSlot;
    private PawnExplorerColors pawnExplorerColor;
    /** 
     * Position of the button where the player is placed 
     */
    private Position position;


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

    public PawnExplorerColors getPawnExplorerColor() {
        return pawnExplorerColor;
    }
    public void setPawnExplorerColor(PawnExplorerColors pawnExplorerColor) {
        this.pawnExplorerColor = pawnExplorerColor;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    } 
}
