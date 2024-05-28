package com.theisland.utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Path2D;

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

            // If there's only 1 pawn on the Slot
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

                        case GREEN:
                            g.drawImage(ImagePaths.PAWN_EXPLORER_GREEN.getImageForPanelBGImage(), 10, 7, null);
                            break;

                        case YELLOW:
                            g.drawImage(ImagePaths.PAWN_EXPLORER_YELLOW.getImageForPanelBGImage(), 12, 7, null);
                            break;
                    }
                }
            
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
