package com.theisland.windows;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.theisland.enums.ImagePaths;

public class MainMenuTestWindow {
	

	/**
	 * Create the "Main Menu" frame
	 */
	public MainMenuTestWindow() {
		
		
		JFrame frame = new JFrame();
		
		frame.setSize(979, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		

		// Main Panel Frame (With Background Image)
		JPanelWithBackgroundImage mainPanel = new JPanelWithBackgroundImage(ImagePaths.GAME_SPLASH.getImagePath());
		mainPanel.setLayout(null);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		// Play button
		JButton playButton = new JButton("JOUER");
		playButton.setFocusPainted(false);
		playButton.setFont(new Font("Arial", Font.BOLD, 82));
		playButton.setBounds(323, 427, 317, 126);
		mainPanel.add(playButton);
	}
}
