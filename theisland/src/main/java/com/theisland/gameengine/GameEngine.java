package com.theisland.gameengine;

import javax.swing.JOptionPane;

import com.theisland.enums.GameStatus;
import com.theisland.gameelements.BoardSlot;
import com.theisland.main.EnvironmentVariables;
import com.theisland.pawns.Pawn;
import com.theisland.players.Player;
import com.theisland.utils.JButtonHexagon;
import com.theisland.utils.Position;

public class GameEngine {


    // [#] Initialization functions

    /**
     * Place a player depending on the plate
     * @param boardSlot
     * @param env
     */
    public static void init_placeExplorerPawn(BoardSlot boardSlot, EnvironmentVariables env) {
        
        Player currentPlayerTurn = env.getGameVariables().getCurrentPlayerTurn();

        // Save "PawnExplorer"'s BoardSlot in itself
        currentPlayerTurn.getExplorerToPlace().get(0).setCurrentBoardSlot(boardSlot);

        // Add "PawnExplorer" to the Player's initialized PawnExplorer list 
        currentPlayerTurn.addOwnedExplorers( currentPlayerTurn.getExplorerToPlace().get(0) );
        
        // Add the pawn to the "BoardSlot"
        boardSlot.addPawn(currentPlayerTurn.getExplorerToPlace().get(0));

        // Remove "PawnExplorer" from the list of Explorers to place
        currentPlayerTurn.removeExplorerToPlace( currentPlayerTurn.getExplorerToPlace().get(0) );

        // Switch Player's turn
        if(currentPlayerTurn.getID() == 4) {
            env.getGameVariables().setCurrentPlayerTurn( env.getGameVariables().getPlayers().get(0) );
        } else {
            env.getGameVariables().setCurrentPlayerTurn( env.getGameVariables().getPlayers().get(currentPlayerTurn.getID()) );
        }
    }


    /**
     * Move a {@code Pawn}, no matter whitch type of pawn it is
     * @param hexButtonClicked the HexagonButton clicked
     * @param pawn the pawn to move
     * @param env the {@code EnvironmentVariables}
     */
    public static void movePawn(JButtonHexagon hexButtonClicked, Pawn concernedPawn, EnvironmentVariables env) {

        Position firstClick = env.getGameVariables().getGameBoard().getFirstClickOnBoard();
        Position secondClick = env.getGameVariables().getGameBoard().getSecondClickOnBoard();
        
        //Selectionné le 1er le boutton [OK]
        if(firstClick.getX() == 0 && firstClick.getY() ==0) {

            firstClick.setX(hexButtonClicked.getX());
            firstClick.setY(hexButtonClicked.getY());

        } // Deselectionner le boutton [OK]
        else if(firstClick.getX() == hexButtonClicked.getX() && firstClick.getY() == hexButtonClicked.getY()) {

            firstClick.setX(0);
            firstClick.setY(0);
            JOptionPane.showMessageDialog(null, "Pion déselectionné");

            // Update Env Variables
			env.getGameVariables().setCurrentGameStatus(GameStatus.SELECT_PLAYER_TO_MOVE);

        
        // Sélection du 2e bouton [OK]
        } else {

            secondClick.setX(hexButtonClicked.getX());
            secondClick.setY(hexButtonClicked.getY());

            // Renvoie 1 si l'objets à été deplacé dans une case adjacente sinon  renvoi 0
            if(movePawnExplorer(concernedPawn, env) == 1){
                firstClick.setX(0);
                firstClick.setY(0);

                // [#] Change the "BoardSlot" of the pawn
                    // Add Pawn to the new "BoardSlot"
                hexButtonClicked.getBoardSlot().addPawn(concernedPawn);
                    // Remove Pawn from its old "BoardSlot"
                concernedPawn.getCurrentBoardSlot().removePawn(concernedPawn);
                    // Change Pawn's "currentBoardSlot"
                concernedPawn.setCurrentBoardSlot(hexButtonClicked.getBoardSlot());

                // [#] Update Env Variables
			    env.getGameVariables().setCurrentGameStatus(GameStatus.SELECT_PLAYER_TO_MOVE);
            };
        }
    }



    /**
     * Move a {@code PawnExplorer and change some settings of the player and the pawn}
     * @return {@code 1} if the pawn has been moves successfully, {@code 0} if not
     */
    private static int movePawnExplorer(Pawn pawnToMove, EnvironmentVariables env) {

        System.out.println("### ENTREE DANS \"movePawnExplorer()\" ###");

        Position firstClick = env.getGameVariables().getGameBoard().getFirstClickOnBoard();
        Position secondClick = env.getGameVariables().getGameBoard().getSecondClickOnBoard();

        //Si le premier et le second clicks ont les même ordonnées
        if(firstClick.getY() == secondClick.getY()){

            // Left Neighbor
            if(firstClick.getX()-53 == secondClick.getX()) {
                return 1;

            // Right Neighbor
            } else if(firstClick.getX()+53 == secondClick.getX()){
                return 1;
            }
        
        // Bottom-Left Neighbor
        } else if( ((firstClick.getX()-27 == secondClick.getX()) || (firstClick.getX()-26 == secondClick.getX())) && firstClick.getY()+45 == secondClick.getY()){
            return 1;

        // Top-Left Neighbor
        } else if( ((firstClick.getX()-27 == secondClick.getX()) || (firstClick.getX()-26 == secondClick.getX())) && firstClick.getY()-45 == secondClick.getY()){
            return 1;

        // Top-Right Neighbor
        } else if( ((firstClick.getX()+26 == secondClick.getX()) || (firstClick.getX()+27 == secondClick.getX())) && firstClick.getY()-45 == secondClick.getY()){
            return 1;

        // Bottom-Right Neighbor
        } else if( ((firstClick.getX()+26 == secondClick.getX()) || (firstClick.getX()+27 == secondClick.getX())) && firstClick.getY()+45 == secondClick.getY()){
            return 1;
        }
        return 0;
    }
}
