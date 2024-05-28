package com.theisland.gameengine;

import com.theisland.gameelements.BoardSlot;
import com.theisland.main.EnvironmentVariables;
import com.theisland.players.Player;

public class GameEngine {


    // [#] Initialization functions

    /**
     * Place a player depending on the plate
     * @param boardSlot
     * @param env
     */
    public static void init_placeExplorerPawn(BoardSlot boardSlot, EnvironmentVariables env) {
        
        Player currentPlayerTurn = env.getGameVariables().getCurrentPlayerTurn();

        currentPlayerTurn.addOwnedExplorers( currentPlayerTurn.getExplorerToPlace().get(0) );
        boardSlot.addPawn(currentPlayerTurn.getExplorerToPlace().get(0));

        System.out.println("ID : " + currentPlayerTurn.getID() + " ; Trésors : " + currentPlayerTurn.getExplorerToPlace().get(0).getTreasureAmount() );

        currentPlayerTurn.removeExplorerToPlace( currentPlayerTurn.getExplorerToPlace().get(0) );

        if(currentPlayerTurn.getID() == 4) {
            env.getGameVariables().setCurrentPlayerTurn( env.getGameVariables().getPlayers().get(0) );
        } else {
            env.getGameVariables().setCurrentPlayerTurn( env.getGameVariables().getPlayers().get(currentPlayerTurn.getID()) );
        }
    }

}
