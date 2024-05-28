package com.theisland.main;

import java.util.ArrayList;
import java.util.List;

import com.theisland.enums.GameProperties;
import com.theisland.gameelements.GameBoard;
import com.theisland.gameelements.MonsterDice;
import com.theisland.pawns.PawnMonster;
import com.theisland.players.Player;

public class GameVariables {

    /*
     * Useless to store every {@code Tiles} & {@code Pawn} of the game
     * here, knowing that {@code gameBoard} sores every {@code Tile} &
     * {@code Pawn}
     */
    
    private GameBoard gameBoard;
    private MonsterDice monsterDice;
    private List<PawnMonster> pawnMonsters;
    // Player variables
    private List<Player> players;

    
    /**
     * {@code GameVariables} Constructor
     */
    public GameVariables() {
        this.gameBoard = new GameBoard();
        this.pawnMonsters = new ArrayList<>();
        this.players = new ArrayList<>();
    }


    public void initPlayers() {

        for(int i = 0; i < Integer.parseInt( GameProperties.MAX_PLAYERS.getGameProperty() ); i++) {
            
            Player player = new Player();
            player.init(this);

            this.players.add(player);
        }
    }


    // Adders

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    // Getters & Setters

    public GameBoard getGameBoard() {
        return gameBoard;
    }
    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public MonsterDice getMonsterDice() {
        return monsterDice;
    }
    public void setMonsterDice(MonsterDice monsterDice) {
        this.monsterDice = monsterDice;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<PawnMonster> getPawnMonsters() {
        return pawnMonsters;
    }
    public void setPawnMonsters(List<PawnMonster> pawnMonsters) {
        this.pawnMonsters = pawnMonsters;
    }
}
