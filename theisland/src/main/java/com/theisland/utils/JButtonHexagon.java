package com.theisland.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Path2D;

import javax.swing.JButton;

public class JButtonHexagon extends JButton {

    private static final int SIDES = 6;



    public JButtonHexagon() {

        setPreferredSize(new Dimension(100, 100));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }



    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(getBackground());
        }
        /*
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(createHexagon());
        super.paintComponent(g);*/
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

}
