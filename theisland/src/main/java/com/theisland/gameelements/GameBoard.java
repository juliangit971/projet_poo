package com.theisland.gameelements;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
                hexButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                hexButton.setBounds(posX + (BoardSlotProperties.SEPARATION_X * j), posY, 60, 66);
                hexButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Hexagonal Button at position [" + boardSlot.getPosition().getX() + ", " + boardSlot.getPosition().getY() + "] Pressed!");
                    }
                });

                // Save the Button in the Slot & the Slot in the Button
                hexButton.setBoardSlot(boardSlot);
                boardSlot.setHexagonButton(hexButton);

                // Add the {@code BoardSlot} to the list
                rowOfSlots.add(boardSlot);
            }

            // Add the {@code List<BoardSlot>} to the list
            boardSlots.add(rowOfSlots);

            // Increment Y postion
            posY += BoardSlotProperties.SEPARATION_Y;
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
