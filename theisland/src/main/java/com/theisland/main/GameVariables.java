package com.theisland.main;

import java.util.List;

import com.theisland.gameelements.GameBoard;
import com.theisland.gameelements.MonsterDice;
import com.theisland.pawns.Pawn;
import com.theisland.tiles.Tile;

public class GameVariables {
    
    private GameBoard gameBoard;
    private List<Tile> tiles;
    private List<Pawn> pawns;
    private MonsterDice monsterDice;


    public GameVariables() {
        this.gameBoard = new GameBoard();
    }

    // Getters & Setters


    public GameBoard getGameBoard() {
        return gameBoard;
    }
    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public List<Tile> getTiles() {
        return tiles;
    }
    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public List<Pawn> getPawns() {
        return pawns;
    }
    public void setPawns(List<Pawn> pawns) {
        this.pawns = pawns;
    }

    public MonsterDice getMonsterDice() {
        return monsterDice;
    }
    public void setMonsterDice(MonsterDice monsterDice) {
        this.monsterDice = monsterDice;
    }
}
