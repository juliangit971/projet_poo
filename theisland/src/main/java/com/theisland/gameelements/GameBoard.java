package com.theisland.gameelements;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.theisland.enums.ImagePaths;
import com.theisland.tiles.TileBeach;
import com.theisland.tiles.TileForest;
import com.theisland.tiles.TileMountain;
import com.theisland.tiles.TileProperties;
import com.theisland.utils.GeneralUtils;
import com.theisland.utils.JButtonHexagon;
import com.theisland.utils.Position;

public class GameBoard {

    private List<List<BoardSlot>> boardSlots = new ArrayList<>();


    /**
     * Create every {@code BoardSlot} needed for the {@code GameBoard}
     * with their associated {@code JButtonHexagon} 
     */
    public void init() {

        Integer buttonToAdd = 0;
        Integer posX = 0;
        Integer posY = BoardSlotProperties.POS_Y_INIT;

        for(int i = 0; i < BoardSlotProperties.ROW_AMOUNT; i++){

            List<BoardSlot> rowOfSlots = new ArrayList<>();


            if(i == 0 || i == 12) {
                buttonToAdd = BoardSlotProperties.BUTTON_TO_ADD_ROWS_0_12;
                posX = BoardSlotProperties.POS_X_ROWS_0_12;
            } else if(i == 5 || i == 7) {
                buttonToAdd = BoardSlotProperties.BUTTON_TO_ADD_ROWS_5_7;
                posX = BoardSlotProperties.POS_X_ROWS_5_7;
            } else if(i%2 == 1) {
                buttonToAdd =  BoardSlotProperties.BUTTON_TO_ADD_ROWS_ODD;
                posX = BoardSlotProperties.POS_X_ROWS_ODD;
            } else if(i%2 == 0) {
                buttonToAdd = BoardSlotProperties.BUTTON_TO_ADD_ROWS_EVEN;
                posX = BoardSlotProperties.POS_X_ROWS_EVEN;
            } 


            for(int j = 0; j < buttonToAdd; j++) {

                BoardSlot boardSlot = new BoardSlot();
                // Set Row and Line position of the button
                boardSlot.setPosition(new Position(i, j));

                JButtonHexagon hexButton = new JButtonHexagon();
                // hexButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                hexButton.setBounds(posX + (BoardSlotProperties.SEPARATION_X * j), posY, 60, 66);
                
                // DO NOT INITIALIZE BUTTON ACTION AT THE BEGINNING
                // hexButton.addActionListener(new ActionListener() {
                //     @Override
                //     public void actionPerformed(ActionEvent e) {
                //         JOptionPane.showMessageDialog(null, "Hexagonal Button at position [" + boardSlot.getPosition().getX() + ", " + boardSlot.getPosition().getY() + "] Pressed!");
                //     }
                // });

                // Save the Button in the Slot & the Slot in the Button
                hexButton.setBoardSlot(boardSlot);
                boardSlot.setHexagonButton(hexButton);

                // Add the {@code BoardSlot} to the list
                rowOfSlots.add(boardSlot);
            }

            // Add the {@code List<BoardSlot>} to the list
            this.boardSlots.add(rowOfSlots);

            // Increment Y postion
            posY += BoardSlotProperties.SEPARATION_Y;
		}
    }


    /**
     * Initialize every tiles on the correct {@code BoardSlot}
     */
    public void initTiles() {

        int k = 0;

        int beachTiles = TileProperties.AMOUNT_TILE_BEACH;
        Image beachTileImage = ImagePaths.TILE_BEACH.getImageForPanelBGImage();

        int forestTiles = TileProperties.AMOUNT_TILE_FOREST;
        Image forestTileImage = ImagePaths.TILE_FOREST.getImageForPanelBGImage();

        int mountainTiles = TileProperties.AMOUNT_TILE_MOUNTAIN;
        Image mountainTileImage = ImagePaths.TILE_MOUNTAIN.getImageForPanelBGImage();
          

        for(int i = BoardSlotProperties.ROWS_WITH_TILES.getX(); i <= BoardSlotProperties.ROWS_WITH_TILES.getY(); i++) {

            for(int j = BoardSlotProperties.COLUMNS_WITH_TILES.get(k).getX(); j <= BoardSlotProperties.COLUMNS_WITH_TILES.get(k).getY(); j++) {
                
                Integer tileToUse = null; // 1 = Beach ; 2 = Forest : 3 = Mountain
                boolean isTileValid = false;

                // If the Slot isn't the slot where the {@code PawnSnake} is supposed to be
                if (i != BoardSlotProperties.SLOT_WITHOUT_TILE_EXCEPTION.getX() || j != BoardSlotProperties.SLOT_WITHOUT_TILE_EXCEPTION.getY()) {

                    // Select a tile Randomly
                    while (!isTileValid) {

    
                        tileToUse = GeneralUtils.getRandomNumber(1, 4);
    
                        switch (tileToUse) {
    
                            case 1:
                                if(beachTiles - 1 < 0) {
                                    isTileValid = false;
                                } else {
                                    isTileValid = true;
                                    beachTiles--;
                                }
    
                                break;
                            
                            case 2:
                                if(forestTiles - 1 < 0) {
                                    isTileValid = false;
                                } else {
                                    isTileValid = true;
                                    forestTiles--;
                                }
    
                                break;
                            
                            case 3:
                                if(mountainTiles - 1 < 0) {
                                    isTileValid = false;
                                } else {
                                    isTileValid = true;
                                    mountainTiles--;
                                }
    
                                break;
                            
                            default:
                                isTileValid = false;
                                break;
                        }
                    }

                    // Set the right tile image
                    JButtonHexagon hexButton = boardSlots.get(i).get(j).getHexagonButton();

                    switch (tileToUse) {
                        case 1:
                            hexButton.setBackgroundImage(beachTileImage);
                            this.boardSlots.get(i).get(j).setTile(new TileBeach());
                            break;
                        
                        case 2:
                            hexButton.setBackgroundImage(forestTileImage);
                            this.boardSlots.get(i).get(j).setTile(new TileForest());
                            break;
                        
                        case 3:
                            hexButton.setBackgroundImage(mountainTileImage);
                            this.boardSlots.get(i).get(j).setTile(new TileMountain());
                            break;
                    }                      
                }

            }

            k++;
		}
    }


    /**
     * Remove every 
     */
    public void resetHexButtonsActionListener() {

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

                JButtonHexagon hexButton = this.boardSlots.get(i).get(j).getHexagonButton();

                // Remove every {@code ActionListener}
                ActionListener[] listeners = hexButton.getActionListeners();
                for (ActionListener listener : listeners) {
                    hexButton.removeActionListener(listener);
                }

                // Remove {@code HAND_CURSOR} of the button
                hexButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
		}
    }

    // Getters & Setters


    public List<List<BoardSlot>> getBoardSlots() {
        return boardSlots;
    }
    public void setBoardSlots(List<List<BoardSlot>> boardSlots) {
        this.boardSlots = boardSlots;
    }
}
