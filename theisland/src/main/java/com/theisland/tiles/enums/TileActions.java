package com.theisland.tiles.enums;

public enum TileActions {

    // Green Borders (Immediate Play)
    GREEN_PLACE_SHARK("Placer un requin"),
    GREEN_PLACE_WHALE("Placer une baleine"),
    GREEN_PLACE_BOAT("Placer un bateau"),
    GREEN_PLACE_WHIRLPOOL("Placer un tourbillon"),
    GREEN_PLACE_VOLCANO("Palcer le volcan"),

    // Red Borders (Turn Beginning)
    RED_DOLPHIN_HELP("Un dauphin vient en aide à l'un de vos nageurs. Déplacez un de vos nageurs de 1 à 3 cases de mer."),
    RED_MOVE_BOAT("Les vents vous sont favorables. Déplacez un des bateaux que vous contrôlez de 1 à 3 cases de mer. "),
    RED_MOVE_SNAKE("Déplacez le serpent de mer de votre choix déjà présent sur le plateau de jeu sur n'importe quelle case de mer inoccupée"),
    RED_MOVE_SHARK("Déplacez le requin de votre choix déjà présent sur le plateau de jeu sur n'importe quelle case de mer inoccupée."),
    RED_MOVE_WHALE("Déplacez la baleine de votre choix déjà présente sur le plateau de jeu sur n'importe quelle case de mer inoccupée"),

    // Red Borders (Defense)
    DEF_KILL_SHARK("Quand un autre joueur déplace un requin dans une case de mer occupée par l'un  de vos nageurs, vous pouvez jouer cette tuile de terrain pour retirer le requin du jeu. Tous les nageurs demeurent dans la case mer."),
    DEF_KILL_WHALE("Quand un autre joueur déplace une baleine dans une case de mer occupée par un  bateau que vous contrôlez, vous pouvez jouer cette tuile de terrain pour retirer la  baleine du jeu. Votre bateau demeure dans la case de mer.");


    private String tileAction;

    private TileActions(String tileAction) {
        this.tileAction = tileAction;
    }

    public String getTileAction() {
        return tileAction;
    }
}
