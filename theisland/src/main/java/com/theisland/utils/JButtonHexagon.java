package com.theisland.utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.util.HashMap;

import javax.swing.JButton;

import com.theisland.enums.ImagePaths;
import com.theisland.gameelements.BoardSlot;
import com.theisland.pawns.PawnExplorer;

public class JButtonHexagon extends JButton {


    private static final int SIDES = 6;
    private BoardSlot boardSlot;
    private Image backgroundImage = null;


    public JButtonHexagon() {

        setPreferredSize(new Dimension(100, 100));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }



    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);

        // If a tile is defined for the button 
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 8, 0, null);
        }

        // If there are pawns on the button
        if(this.boardSlot.getPawns().size() > 0) {

            // If there's only 1 Pawn on the Slot
            if(this.boardSlot.getPawns().size() == 1) {

                if(this.boardSlot.getPawns().get(0) instanceof PawnExplorer) {

                    PawnExplorer explorer = (PawnExplorer) this.boardSlot.getPawns().get(0);

                    switch (explorer.getColor()) {
                        case RED:
                            g.drawImage(ImagePaths.PAWN_EXPLORER_RED.getImageForPanelBGImage(), 10, 7, null);
                            break;

                        case BLUE:
                            g.drawImage(ImagePaths.PAWN_EXPLORER_BLUE.getImageForPanelBGImage(), 10, 7, null);
                            break;

                        case YELLOW:
                            g.drawImage(ImagePaths.PAWN_EXPLORER_YELLOW.getImageForPanelBGImage(), 12, 7, null);
                            break;

                        case GREEN:
                            g.drawImage(ImagePaths.PAWN_EXPLORER_GREEN.getImageForPanelBGImage(), 10, 7, null);
                            break;                        
                    }
                }
            
            // Esle if there are more than 1 Pawn
            } else {

                HashMap<String, Boolean> boolMap = new HashMap<>();
                // PawnExplorer
                boolMap.put("isRedExplorerPlaced", false);
                boolMap.put("isBlueExplorerPlaced", false);
                boolMap.put("isGreenExplorerPlaced", false);
                boolMap.put("isYellowExplorerPlaced", false);
                // PawnMonster
                boolMap.put("isSharkPlaced", false);
                boolMap.put("isSnakePlaced", false);
                boolMap.put("isWhalePlaced", false);
                // PawnBoat
                boolMap.put("isBoatPlaced", false);
                

                this.boardSlot.getPawns().stream().forEach(pwn -> {
                    if(pwn instanceof PawnExplorer) {

                        PawnExplorer explorer = (PawnExplorer) pwn;
    
                        switch (explorer.getColor()) {
                            case RED:

                                if(boolMap.get("isRedExplorerPlaced") == false) {
                                    g.drawImage(ImagePaths.MINI_PAWN_EXPLORER_RED.getImageForPanelBGImage(), 10, 20, null);
                                    boolMap.put("isRedExplorerPlaced", true);
                                }
                                break;
    
                            case BLUE:

                                if(boolMap.get("isBlueExplorerPlaced") == false) {
                                    g.drawImage(ImagePaths.MINI_PAWN_EXPLORER_BLUE.getImageForPanelBGImage(), 20, 20, null);
                                    boolMap.put("isBlueExplorerPlaced", true);
                                }
                                break;

                            case YELLOW:

                                if(boolMap.get("isYellowExplorerPlaced") == false) {
                                    g.drawImage(ImagePaths.MINI_PAWN_EXPLORER_YELLOW.getImageForPanelBGImage(), 32, 20, null);
                                    boolMap.put("isYellowExplorerPlaced", true);
                                }
                                break;
    
                            case GREEN:

                                if(boolMap.get("isGreenExplorerPlaced") == false) {
                                    g.drawImage(ImagePaths.MINI_PAWN_EXPLORER_GREEN.getImageForPanelBGImage(), 40, 20, null);
                                    boolMap.put("isGreenExplorerPlaced", true);
                                }
                                break;
                        }
                    }
                });
            }

        } 
    }


    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(createHexagon());
    }


    /**
     * Create Hexagone with mathematical calculus
     * @return the hexagon {@code Shape} Object
     */
    private Shape createHexagon() {
        Path2D hexagon = new Path2D.Double();
        double centerX = getWidth() / 2.0;
        double centerY = getHeight() / 2.0;
        double radius = Math.min(centerX, centerY);
        for (int i = 0; i < SIDES; i++) {
            double angle = Math.toRadians(60 * i);
            double y = centerX + radius * Math.cos(angle);
            double x = centerY + radius * Math.sin(angle);
            if (i == 0) {
                hexagon.moveTo(x, y);
            } else {
                hexagon.lineTo(x, y);
            }
        }
        hexagon.closePath();
        return hexagon;
    }


    @Override
    public boolean contains(int x, int y) {
        return createHexagon().contains(x, y);
    }




    // Getters & Setters

    public BoardSlot getBoardSlot() {
        return boardSlot;
    }
    public void setBoardSlot(BoardSlot boardSlot) {
        this.boardSlot = boardSlot;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
