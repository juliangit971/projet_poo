package com.theisland.windows;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.JPanel;

import com.theisland.utils.FileManager;


/**
 * Create a background image specificaly for JPanel
 */
public class JPanelWithBackgroundImage extends JPanel {

    private Image img;

    
    public JPanelWithBackgroundImage(URL imagePath) {
        FileManager fm = new FileManager();
        img = fm.getImageFromLocalRes(imagePath);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }
}
