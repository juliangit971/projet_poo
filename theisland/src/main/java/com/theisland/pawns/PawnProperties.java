package com.theisland.pawns;

import java.util.Arrays;
import java.util.List;

public class PawnProperties {

    final Integer AMOUNT_EXPLORERS_PER_PLAYERS = 10;
    final Integer AMOUNT_EXPLORERS_TOTAL = AMOUNT_EXPLORERS_PER_PLAYERS * 4;

    final List<Integer> TREASURE_VALUES = Arrays.asList(1, 1, 1, 2, 2, 3, 3, 4, 5, 6);

    final Integer AMOUNT_SNAKES = 5;
    final Integer AMOUNT_SHARKS = 6;
    final Integer AMOUNT_WHALES = 5;


    // Getters


    public Integer getAmountExplorersPerPlayers() {
        return AMOUNT_EXPLORERS_PER_PLAYERS;
    }

    public Integer getAmountExplorersTotal() {
        return AMOUNT_EXPLORERS_TOTAL;
    }

    public List<Integer> getTreasureValues() {
        return TREASURE_VALUES;
    }

    public Integer getAmountSnakes() {
        return AMOUNT_SNAKES;
    }
    
    public Integer getAmountSharks() {
        return AMOUNT_SHARKS;
    }

    public Integer getAmountWhales() {
        return AMOUNT_WHALES;
    } 
}
