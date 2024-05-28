package com.theisland.windows;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.theisland.enums.ImagePaths;
import com.theisland.utils.JButtonHexagon;

import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.JButton;

public class GameTestWindow {
	

	/**
	 * Create the frame.
	 */
	public GameTestWindow() {
		
		
		JFrame frame = new JFrame();
		
		frame.setSize(948, 774);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		// Main Panel
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		

		// North Panel
		JPanel northPanel = new JPanel();
		northPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		// Player 4 Label
		JLabel player4Label = new JLabel("Joueur 4");
		player4Label.setFont(new Font("Dialog", Font.BOLD, 21));
		northPanel.add(player4Label, BorderLayout.WEST);
		

		// West Panel
		JPanel westPanel = new JPanel();
		westPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new GridLayout(16, 1, 0, 0));
		
		// Player 1 Label
		JLabel player1Label = new JLabel("Joueur 1");
		player1Label.setFont(new Font("Dialog", Font.BOLD, 21));
		westPanel.add(player1Label);
		
		JButton shuffleTilesButton = new JButton("Shuffle Tiles");
		westPanel.add(shuffleTilesButton);
		

		// South Panel
		JPanel southPanel = new JPanel();
		southPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));
		
		// Player 2 Label
		JLabel player2Label = new JLabel("Joueur 2");
		player2Label.setHorizontalAlignment(SwingConstants.TRAILING);
		player2Label.setFont(new Font("Dialog", Font.BOLD, 21));
		southPanel.add(player2Label, BorderLayout.WEST);
		

		// East Panel
		JPanel eastPanel = new JPanel();
		eastPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new GridLayout(16, 1, 0, 0));
		
		// Player 3 Label
		JLabel player3Label = new JLabel("Joueur 3");
		player3Label.setFont(new Font("Arial", Font.BOLD, 21));
		eastPanel.add(player3Label);
		

		// Map Image Panel
		Image mapImage = ImagePaths.GAME_MAP.getImageForPanelBGImage();

		JPanelWithBackgroundImage mapPanel = new JPanelWithBackgroundImage(ImagePaths.GAME_MAP.getImagePath());

		// Set "preferredSize" as the same size as the map so it doesn't get deformed when something is added in player areas
		mapPanel.setPreferredSize(new Dimension(mapImage.getWidth(null), mapImage.getHeight(null)));  
		mapPanel.setLayout(null);
		mainPanel.add(mapPanel, BorderLayout.CENTER);


		
	}
}
