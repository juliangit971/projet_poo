package com.theisland.enums;


/**
 * Make us able to to know of it's the game initialization (place every pawns),
 * in what type of turn we are (if it's "Jouer une tuile de son deck"; "Déplacer un joueur";
 * "Retirer une tuiles" or "Lancer dé créature")
 */
public enum GameStatus {

    // [#] Game initialization
    INIT_PLACE_PLAYER_PAWNS("4"),


    // [#] Game Status Types
    PLAY_TILE_FROM_DECK("Jouer une tuile de son deck (une des tuiles que vous avez ramassées)"),

    SELECT_PLAYER_TO_MOVE("Sélectionner le joueur à déplacer"),
    MOVE_SELECTED_PLAYER("Déplacer le joueur sélectionné"),

    REMOVE_TILE_FROM_BOARD("Retirer une tuile du plateau"),

    PLAY_MONSTER_DICE("Lancer le dé créature"),

    PLACE_MONSTER_ON_BOARD("Placer un monstre sur le plateau");

    
    private String gameStatus;

    private GameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
    
    public String getGameStatus() {
        return gameStatus;
    }
}
