package com.theisland.players;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.theisland.main.GameVariables;
import com.theisland.pawns.PawnBoat;
import com.theisland.pawns.PawnExplorer;
import com.theisland.pawns.PawnProperties;
import com.theisland.pawns.enums.PawnExplorerColors;
import com.theisland.tiles.Tile;

public class Player {

    private Integer ID;
    private PawnExplorerColors color;
    private List<PawnExplorer> ownedExplorers;
    private List<PawnExplorer> savedExplorers;
	private List<Tile> ownedTiles;
    private List<PawnBoat> ownedBoat;

    
    public Player() {
        this.ownedExplorers = new ArrayList<>();
        this.savedExplorers = new ArrayList<>();
        this.ownedBoat = new ArrayList<>();
    }


    /**
     * Initialize every info of a player
     */
    public void init(GameVariables gameVariables) {

        // Init Player ID & Color
        switch(gameVariables.getPlayers().size()) {

            case 0:
                this.ID = 1;
                this.color = PawnExplorerColors.RED;
                break;

            case 1:
                this.ID = 2;
                this.color = PawnExplorerColors.BLUE;
                break;

            case 2:
                this.ID = 3;
                this.color = PawnExplorerColors.YELLOW;
                break;

            case 3:
                this.ID = 4;
                this.color = PawnExplorerColors.GREEN;
                break;

            default:
                JOptionPane.showMessageDialog(null, "Il existe déjà 4 joueurs dans le jeu !");
                return;
        }


        // Init Player Pawns
        for(int i = 0; i < PawnProperties.AMOUNT_EXPLORERS_PER_PLAYERS; i++) {

            PawnExplorer explorer = new PawnExplorer();

            explorer.setStatus(null);		// The pawn never has been used
            explorer.setIsAlive(true);		// Is alive, but not initialized yet
            explorer.setTreasureAmount(PawnProperties.TREASURE_VALUES.get(i));
            explorer.setIsSwimmer(false);	// Explorer never is a swimmer when initialized
            explorer.setColor(this.color);
            
            // Add PawnExplorer to list
            this.ownedExplorers.add(explorer);
        }   
    }


    // Getters & Setters


    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        this.ID = iD;
    }

    public PawnExplorerColors getColor() {
        return color;
    }
    public void setColor(PawnExplorerColors color) {
        this.color = color;
    }

    public List<PawnExplorer> getOwnedExplorers() {
        return ownedExplorers;
    }
    public void setOwnedExplorers(List<PawnExplorer> ownedExplorers) {
        this.ownedExplorers = ownedExplorers;
    }

    public List<PawnExplorer> getSavedExplorers() {
        return savedExplorers;
    }
    public void setSavedExplorers(List<PawnExplorer> savedExplorers) {
        this.savedExplorers = savedExplorers;
    }

	public List<Tile> getOwnedTiles() {
		return ownedTiles;
	}
	public void setOwnedTiles(List<Tile> ownedTiles) {
		this.ownedTiles = ownedTiles;
	}

    public List<PawnBoat> getOwnedBoat() {
        return ownedBoat;
    }
    public void setOwnedBoat(List<PawnBoat> ownedBoat) {
        this.ownedBoat = ownedBoat;
    }
}
