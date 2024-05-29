package com.theisland.windows;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.theisland.enums.GameStatus;
import com.theisland.enums.ImagePaths;
import com.theisland.enums.WindowNames;
import com.theisland.gameelements.BoardSlot;
import com.theisland.gameelements.BoardSlotProperties;
import com.theisland.gameengine.GameEngine;
import com.theisland.main.EnvironmentVariables;
import com.theisland.misc.EnhancedLog;
import com.theisland.pawns.Pawn;
import com.theisland.pawns.PawnExplorer;
import com.theisland.pawns.PawnProperties;
import com.theisland.utils.JButtonHexagon;

public class GameWindow {


    private EnvironmentVariables env;
	private Pawn selectedPawn;


	public GameWindow(EnvironmentVariables env) {
		this.env = env;
	}


    public void setView(JFrame frame) {

		// Env Variables Update
		if(env.getIsGameWindowInitialized() == false) {
			EnhancedLog.eventLogger("Window \"" + WindowNames.DEFAULT.getWindowName() + "\" set !" , "INFO");
			env.setIsGameWindowInitialized(true);
		}
        
        // Reset frame to make it empty
        WindowUtils.resetWindow(frame);

        // Frame Settings
        frame.setTitle(WindowNames.GAME.getWindowName());
        frame.setSize(948, 774);

        if(env.getResetWindowPosition()) {
			frame.setLocationRelativeTo(null);
			env.setResetWindowPosition(false);
		}


        // Main Panel
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		

		// North Panel
		JPanel northPanel = new JPanel();
		northPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		// Player 2 Label
		JLabel player2Label = new JLabel("Joueur 2");
		player2Label.setForeground(Color.BLUE);
		player2Label.setFont(new Font("Dialog", Font.BOLD, 21));

		if(env.getGameVariables().getCurrentPlayerTurn().getID() == 2) {
			player2Label.setBorder(new LineBorder(Color.RED, 2, true));
		} else {
			player2Label.setBorder(new LineBorder(Color.BLACK, 2, true));
		}

		northPanel.add(player2Label, BorderLayout.WEST);
		

		// West Panel
		JPanel westPanel = new JPanel();
		westPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new GridLayout(16, 1, 0, 0));
		
		// Player 1 Label
		JLabel player1Label = new JLabel("Joueur 1");
		player1Label.setForeground(Color.RED);
		player1Label.setFont(new Font("Dialog", Font.BOLD, 21));

		if(env.getGameVariables().getCurrentPlayerTurn().getID() == 1) {
			player1Label.setBorder(new LineBorder(Color.RED, 2, true));
		} else {
			player1Label.setBorder(new LineBorder(Color.BLACK, 2, true));
		}

		westPanel.add(player1Label);


		// South Panel
		JPanel southPanel = new JPanel();
		southPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));
		
		// Player 4 Label
		JLabel player4Label = new JLabel("Joueur 4");
		player4Label.setForeground(new Color(0, 128, 0));
		player4Label.setHorizontalAlignment(SwingConstants.TRAILING);
		player4Label.setFont(new Font("Dialog", Font.BOLD, 21));

		if(env.getGameVariables().getCurrentPlayerTurn().getID() == 4) {
			player4Label.setBorder(new LineBorder(Color.RED, 2, true));
		} else {
			player4Label.setBorder(new LineBorder(Color.BLACK, 2, true));
		}

		southPanel.add(player4Label, BorderLayout.WEST);
		

		// East Panel
		JPanel eastPanel = new JPanel();
		eastPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new GridLayout(16, 1, 0, 0));
		
		// Player 3 Label
		JLabel player3Label = new JLabel("Joueur 3");
		player3Label.setForeground(Color.ORANGE);
		player3Label.setFont(new Font("Arial", Font.BOLD, 21));

		if(env.getGameVariables().getCurrentPlayerTurn().getID() == 3) {
			player3Label.setBorder(new LineBorder(Color.RED, 2, true));
		} else {
			player3Label.setBorder(new LineBorder(Color.BLACK, 2, true));
		}

		eastPanel.add(player3Label);
		

		// Map Image Panel
		Image mapImage = ImagePaths.GAME_MAP.getImageForPanelBGImage();

		JPanelWithBackgroundImage mapPanel = new JPanelWithBackgroundImage(ImagePaths.GAME_MAP.getImagePath());

		// Set "preferredSize" as the same size as the map so it doesn't get deformed when something is added in player areas
		mapPanel.setPreferredSize(new Dimension(mapImage.getWidth(null), mapImage.getHeight(null)));  
		mapPanel.setLayout(null);
		mainPanel.add(mapPanel, BorderLayout.CENTER);



        // [#] Hexagonal JButtons

		// Show every buttons
		Integer buttonToAdd = 0;
		
		for(int i = 0; i < BoardSlotProperties.ROW_AMOUNT; i++){

			
			if(i == 0 || i == 12) {
                buttonToAdd = BoardSlotProperties.BUTTON_TO_ADD_ROWS_0_12;
            } else if(i == 5 || i == 7) {
                buttonToAdd = BoardSlotProperties.BUTTON_TO_ADD_ROWS_5_7;
            } else if(i%2 == 1) {
                buttonToAdd =  BoardSlotProperties.BUTTON_TO_ADD_ROWS_ODD;
            } else if(i%2 == 0) {
                buttonToAdd = BoardSlotProperties.BUTTON_TO_ADD_ROWS_EVEN;
            } 

            for(int j = 0; j < buttonToAdd; j++) {
				/**
				 * "get(i)" : Get the row "i" containing an amount of slots
				 * "get(j)" : Get the Slot at position [i, j] in the map
				 */
				mapPanel.add( env.getGameVariables().getGameBoard().getBoardSlots().get(i).get(j).getHexagonButton() ) ;
            }
		}




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





        // Revalidate to refresh the updated page
		frame.revalidate();
    }
}
