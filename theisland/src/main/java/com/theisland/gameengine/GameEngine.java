package com.theisland.gameengine;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.theisland.enums.GameStatus;
import com.theisland.gameelements.BoardSlot;
import com.theisland.gameelements.BoardSlotProperties;
import com.theisland.main.EnvironmentVariables;
import com.theisland.pawns.Pawn;
import com.theisland.pawns.PawnExplorer;
import com.theisland.pawns.PawnProperties;
import com.theisland.players.Player;
import com.theisland.utils.JButtonHexagon;
import com.theisland.utils.Position;

public class GameEngine {

    private static Pawn selectedPawn;


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
        switchPlayerTurn(env);
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

            // If the pawn can be moved
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
                    // Go back to Pawn selection 
			    env.getGameVariables().setCurrentGameStatus(GameStatus.SELECT_PLAYER_TO_MOVE);
                    // Reduce number of turn 
                env.getGameVariables().setNumberOfTurn( env.getGameVariables().getNumberOfTurn() - 1 );
                    // If nuber of turn reached 0, change player
                if(env.getGameVariables().getNumberOfTurn() == 0) {
                    env.getGameVariables().setNumberOfTurn(3);
                    switchPlayerTurn(env);
                }
            };
        }
    }



    /**
     * Move a {@code PawnExplorer and change some settings of the player and the pawn}
     * @return {@code 1} if the pawn can move to the selected {@code BoardSlot}, {@code 0} if not
     */
    private static int movePawnExplorer(Pawn pawnToMove, EnvironmentVariables env) {

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


    /**
     * Switch to the next player in order to change turn
     * @param env the {@code EnvironmentVariables} to use
     */
    public static void switchPlayerTurn(EnvironmentVariables env) {

        Player currentPlayerTurn = env.getGameVariables().getCurrentPlayerTurn();

        if(currentPlayerTurn.getID() == 4) {
            env.getGameVariables().setCurrentPlayerTurn( env.getGameVariables().getPlayers().get(0) );
        } else {
            env.getGameVariables().setCurrentPlayerTurn( env.getGameVariables().getPlayers().get(currentPlayerTurn.getID()) );
        }
    }


    /**
     * Check current Game Status and perform actions depending on the {@code GameStatus}
     * @param env
     */
    public static void checkCurrentGameStatus(EnvironmentVariables env, JPanel mapPanel) {
        
        // Always reset "ActionListener" of every Hexagonal JButtons before adding new ones
		env.getGameVariables().getGameBoard().resetHexButtonsActionListener();


		// [#] Do some instructions depending on the current game status
		switch (env.getGameVariables().getCurrentGameStatus()) {

			// Explorers' Pawns Initialization
			case INIT_PLACE_PLAYER_PAWNS:

				// Place every clickable tiles where the player can place his pawn
				int k = 0;
				int nonClickableButtons = 0;
				
				// For every "Board Slots" where it is possible to add a Tile
				for(int i = BoardSlotProperties.ROWS_WITH_TILES.getX(); i <= BoardSlotProperties.ROWS_WITH_TILES.getY(); i++) {
					for(int j = BoardSlotProperties.COLUMNS_WITH_TILES.get(k).getX(); j <= BoardSlotProperties.COLUMNS_WITH_TILES.get(k).getY(); j++) {
						
						// If the Slot isn't the slot where the "PawnSnake" is supposed to be
						if (i != BoardSlotProperties.SLOT_WITHOUT_TILE_EXCEPTION.getX() || j != BoardSlotProperties.SLOT_WITHOUT_TILE_EXCEPTION.getY()) {

							List<Pawn> pawns = env.getGameVariables().getGameBoard().getBoardSlots().get(i).get(j).getPawns();

							// If there are pawns on th slot, don't add anything to Hex Button
							if(pawns.size() > 0) {
								nonClickableButtons++;
								continue;
							} 

							JButtonHexagon hexButton = env.getGameVariables().getGameBoard().getBoardSlots().get(i).get(j).getHexagonButton();
								
							hexButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							hexButton.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									GameEngine.init_placeExplorerPawn(hexButton.getBoardSlot(), env);
									env.setRefreshWindow(true);
								}
							});
						}

					}

					k++;
				}

				// If there are no more "BoardSlot" to place an Explorer, go to another action
				if(nonClickableButtons == PawnProperties.AMOUNT_EXPLORERS_TOTAL) {
					JOptionPane.showMessageDialog(null, "Vous avez fini de placer tous les explorateurs !");
					env.getGameVariables().setCurrentGameStatus(GameStatus.SELECT_PLAYER_TO_MOVE);
					env.setRefreshWindow(true);
				}

				break;
		


			// Move a pawn
			case SELECT_PLAYER_TO_MOVE:

				// Check every button
				Integer buttonInRow = 0;
				
				for(int i = 0; i < BoardSlotProperties.ROW_AMOUNT; i++){

					
					if(i == 0 || i == 12) {
						buttonInRow = BoardSlotProperties.BUTTON_TO_ADD_ROWS_0_12;
					} else if(i == 5 || i == 7) {
						buttonInRow = BoardSlotProperties.BUTTON_TO_ADD_ROWS_5_7;
					} else if(i%2 == 1) {
						buttonInRow =  BoardSlotProperties.BUTTON_TO_ADD_ROWS_ODD;
					} else if(i%2 == 0) {
						buttonInRow = BoardSlotProperties.BUTTON_TO_ADD_ROWS_EVEN;
					} 

					for(int j = 0; j < buttonInRow; j++) {
						/**
						 * "get(i)" : Get the row "i" containing an amount of slots
						 * "get(j)" : Get the Slot at position [i, j] in the map
						 */

						BoardSlot boardSlot = env.getGameVariables().getGameBoard().getBoardSlots().get(i).get(j);

						// Necessary to do this or else it doesn't work in the "forEach" method
						Integer valI = i;
						Integer valJ = j;

						// Check for each pawn of a "BoardSlot"
						boardSlot.getPawns().stream().forEach(pawn -> {
							
							if(pawn instanceof PawnExplorer) {
								PawnExplorer explorer = (PawnExplorer) pawn;
								
								// If "PawnExplorerColor" is the same as the Player's Color
								if(explorer.getColor().equals( env.getGameVariables().getCurrentPlayerTurn().getColor() )) {

									JButtonHexagon hexButton = env.getGameVariables().getGameBoard().getBoardSlots().get(valI).get(valJ).getHexagonButton();

									hexButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
									hexButton.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											selectedPawn = pawn;
											GameEngine.movePawn(hexButton, pawn, env);

											// Update Env Variables
											env.getGameVariables().setCurrentGameStatus(GameStatus.MOVE_SELECTED_PLAYER);
											env.setRefreshWindow(true);
										}
									});

								}
							}
						});
						

						mapPanel.add( env.getGameVariables().getGameBoard().getBoardSlots().get(i).get(j).getHexagonButton() );
					}
				}

				break;

			case MOVE_SELECTED_PLAYER:

				// Put a "HAND_CURSOR" on the selected Pawn so we know which one we selected
				selectedPawn.getCurrentBoardSlot().getHexagonButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				
				// Check every button
				Integer buttonToBeChecked = 0;
				
				for(int i = 0; i < BoardSlotProperties.ROW_AMOUNT; i++){

					
					if(i == 0 || i == 12) {
						buttonToBeChecked = BoardSlotProperties.BUTTON_TO_ADD_ROWS_0_12;
					} else if(i == 5 || i == 7) {
						buttonToBeChecked = BoardSlotProperties.BUTTON_TO_ADD_ROWS_5_7;
					} else if(i%2 == 1) {
						buttonToBeChecked =  BoardSlotProperties.BUTTON_TO_ADD_ROWS_ODD;
					} else if(i%2 == 0) {
						buttonToBeChecked = BoardSlotProperties.BUTTON_TO_ADD_ROWS_EVEN;
					} 

					for(int j = 0; j < buttonToBeChecked; j++) {
						/**
						 * "get(i)" : Get the row "i" containing an amount of slots
						 * "get(j)" : Get the Slot at position [i, j] in the map
						 */

						JButtonHexagon hexButton = env.getGameVariables().getGameBoard().getBoardSlots().get(i).get(j).getHexagonButton();
						hexButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								GameEngine.movePawn(hexButton, selectedPawn, env);
								//selectedPawn = null;

								// Update Env Variables
								// env.getGameVariables().setCurrentGameStatus(GameStatus.SELECT_PLAYER_TO_MOVE);
								env.setRefreshWindow(true);
							}
						});
					}
				}

				break;

			default:
				break;
		}
    }

}
