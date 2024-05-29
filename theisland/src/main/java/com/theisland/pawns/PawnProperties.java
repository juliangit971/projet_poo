package com.theisland.pawns;

import java.util.Arrays;
import java.util.List;

public class PawnProperties {

    final static public List<Integer> TREASURE_VALUES = Arrays.asList(1, 1, 1, 2, 2, 3, 3, 4, 5, 6);

    // AMOUNT_EXPLORERS_PER_PLAYERS == 10
    final static public int AMOUNT_EXPLORERS_PER_PLAYERS = TREASURE_VALUES.size();
    // AMOUNT_EXPLORERS_TOTAL == 40
    final static public int AMOUNT_EXPLORERS_TOTAL = AMOUNT_EXPLORERS_PER_PLAYERS * 4;

    final static public int AMOUNT_SNAKES = 5;
    final static public int AMOUNT_SHARKS = 6;
    final static public int AMOUNT_WHALES = 5;

}
