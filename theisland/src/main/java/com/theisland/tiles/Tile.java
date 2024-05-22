package com.theisland.tiles;

import com.theisland.enums.GameElementStatusNames;
import com.theisland.players.Player;
import com.theisland.tiles.enums.TileActions;

abstract public class Tile {

    private GameElementStatusNames status;     // null == not placed on the board yet (useful to know if the tile has initialized)
    private Player owner;               // null == belong to no one
    private TileActions tileAction;     // The action behind the tile

    /**
     * On init : "status" && "owner" == null : Tile not placed yet
     * If "status" == ON_BOARD && "owner" == null : Tile on the board
     * If "status" == OFF_BOARD && "owner" == Player : Tile belong to a player
     * If "status" == OFF_BOARD && "owner" == null : Tile is put aside
     * 
     * !! CAREFUL !! : "status" == ON_BOARD && "owner" == Player : NOT POSSIBLE
    */

    // Getters & Setters

    public GameElementStatusNames getStatus() {
        return status;
    }
    public void setStatus(GameElementStatusNames status) {
        this.status = status;
    }


    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner) {
        this.owner = owner;
    }


    public TileActions getTileAction() {
        return tileAction;
    }
    public void setTileAction(TileActions tileAction) {
        this.tileAction = tileAction;
    }
}
