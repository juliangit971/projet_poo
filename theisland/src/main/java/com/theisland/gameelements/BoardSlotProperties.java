package com.theisland.gameelements;

import java.util.Arrays;
import java.util.List;

import com.theisland.utils.Position;

public class BoardSlotProperties {


    /**
     * Number of rows on the {@code GameBoard} 
     */
    final static public int ROW_AMOUNT = 13;

    /**
     * Buttons to add depending on the row
     */
    final static public int BUTTON_TO_ADD_ROWS_0_12 = 7;
    final static public int BUTTON_TO_ADD_ROWS_5_7 = 12;
    final static public int BUTTON_TO_ADD_ROWS_ODD = 10;
    final static public int BUTTON_TO_ADD_ROWS_EVEN = 11;

    /**
     * Initial Y position of a hexagon Button on the map.
     * Add {@code SEPARATION_Y} to it after each loop iteration
     * in order to obtain the right separation between each hexagons
     */
    final static public int POS_Y_INIT = 15;

    final static public int POS_X_ROWS_0_12 = 169;
    final static public int POS_X_ROWS_5_7 = 34;
    final static public int POS_X_ROWS_ODD = 87;
    final static public int POS_X_ROWS_EVEN = 60;


    /**
     * Constant separation between hexagon buttons
     */
    final static public int SEPARATION_X = 53;
    final static public int SEPARATION_Y = 45;



    /**
     * Rows able to have a tile on it
     * x : Begining row
     * y : Ending row
     * Rows start from 0
     */
    final static public Position ROWS_WITH_TILES = new Position(3, 9);

    /**
     * List of columns able to have a tile on it
     * x : Begining column
     * y : Ending column
     * Columns start from 0
     */
    final static public List<Position> COLUMNS_WITH_TILES = Arrays.asList(
        new Position(3, 6),
        new Position(3, 7),
        new Position(2, 9),
        new Position(2, 8),
        new Position(2, 9),
        new Position(3, 7),
        new Position(3, 6)
    );


    /**
     * Represent the {@code BoardSlot} in the middle of the island where a {@code PawnSnake} should be
     */
    final static public Position BOARD_SLOT_WITHOUT_TILE_EXCEPTION = new Position(6, 5);
}
