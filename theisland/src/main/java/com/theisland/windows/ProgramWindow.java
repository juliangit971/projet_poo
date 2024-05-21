package com.theisland.windows;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.theisland.enums.ImagePaths;
import com.theisland.enums.WindowNames;

public class ProgramWindow {

    private JFrame frame;

    /**
     * Initialize Main window
     */
    public void initialize() {
        frame = new JFrame();

        frame.setTitle(WindowNames.DEFAULT.getWindowName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the window without closing the Java program
        frame.setSize(100, 100);
        frame.setLocationRelativeTo(null);  // Center window on the screen
        frame.setResizable(false);

        // Set Window Icon
        Image programIcon = Toolkit.getDefaultToolkit().getImage(ImagePaths.WINDOW_ICON.getIconPath());
		frame.setIconImage(programIcon);

        frame.setVisible(true);
    }


    // Getters


    public JFrame getFrame() {
        return frame;
    }
}
