package com.theisland.windows;

import javax.swing.JFrame;

public class WindowUtils {

    /**
     * Remove everything from a frame
     * @param frame the frame to be cleaned
     */
    public static void resetWindow(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
    }
}
