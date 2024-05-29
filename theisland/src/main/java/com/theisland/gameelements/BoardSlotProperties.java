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

    final static public int POS_X_ROWS_0_12 = 167;
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
    // ROWS_WITH_TILES_AMOUNT = 7
    final static public Integer ROWS_WITH_TILES_AMOUNT = ROWS_WITH_TILES.getY() - ROWS_WITH_TILES.getX() + 1;

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
     * Amount of tiles per rows
     */
    final static public List<Integer> COLUMNS_WITH_TILES_AMOUNT = Arrays.asList(
        COLUMNS_WITH_TILES.get(0).getY() - COLUMNS_WITH_TILES.get(0).getY() + 1,  // = 4
        COLUMNS_WITH_TILES.get(1).getY() - COLUMNS_WITH_TILES.get(1).getY() + 1,  // = 5
        COLUMNS_WITH_TILES.get(2).getY() - COLUMNS_WITH_TILES.get(2).getY() + 1,  // = 8
        COLUMNS_WITH_TILES.get(3).getY() - COLUMNS_WITH_TILES.get(3).getY() + 1,  // = 7  /!\ Il y en a 6 ici car la case du milieu contient un {@code PawnSnake}
        COLUMNS_WITH_TILES.get(4).getY() - COLUMNS_WITH_TILES.get(4).getY() + 1,  // = 8
        COLUMNS_WITH_TILES.get(5).getY() - COLUMNS_WITH_TILES.get(5).getY() + 1,  // = 5
        COLUMNS_WITH_TILES.get(6).getY() - COLUMNS_WITH_TILES.get(6).getY() + 1   // = 4
    );


    /**
     * Represent the {@code BoardSlot} in the middle of the island where a {@code PawnSnake} should be
     */
    final static public Position SLOT_WITHOUT_TILE_EXCEPTION = new Position(6, 5);
}
