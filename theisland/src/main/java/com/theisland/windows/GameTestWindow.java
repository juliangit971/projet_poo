package com.theisland.windows;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.theisland.enums.ImagePaths;

public class GameTestWindow {
	

	/**
	 * Create the frame.
	 */
	public GameTestWindow() {
		
		
		JFrame frame = new JFrame();
		
		frame.setSize(948, 774);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		northPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Joueur 4");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 21));
		northPanel.add(lblNewLabel_1_1, BorderLayout.WEST);
		
		JPanel westPanel = new JPanel();
		westPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new GridLayout(16, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Joueur 1");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 21));
		westPanel.add(lblNewLabel_1);
		
		JPanel southPanel = new JPanel();
		southPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_2 = new JLabel("Joueur 2");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 21));
		southPanel.add(lblNewLabel_1_2, BorderLayout.WEST);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new GridLayout(16, 1, 0, 0));
		
		JLabel testLabel = new JLabel("Joueur 3");
		testLabel.setFont(new Font("Arial", Font.BOLD, 21));
		eastPanel.add(testLabel);
		
		JLabel lblNewLabel_3 = new JLabel();
		mainPanel.add(lblNewLabel_3, BorderLayout.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon panelIcon = new ImageIcon(ImagePaths.GAME_BOARD.getImagePath());
		lblNewLabel_3.setIcon(panelIcon);

		
	}
}
