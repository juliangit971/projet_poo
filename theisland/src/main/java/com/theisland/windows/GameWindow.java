package com.theisland.windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.theisland.enums.ImagePaths;
import com.theisland.enums.WindowNames;
import com.theisland.gameelements.BoardSlotProperties;
import com.theisland.gameengine.GameEngine;
import com.theisland.main.EnvironmentVariables;
import com.theisland.misc.EnhancedLog;

public class GameWindow {


    private EnvironmentVariables env;


	public GameWindow(EnvironmentVariables env) {
		this.env = env;
	}


    public void setView(JFrame frame) {

		// Env Variables Update
		if(env.getIsGameWindowInitialized() == false) {
			EnhancedLog.eventLogger("Window \"" + WindowNames.DEFAULT.getWindowName() + "\" set !" , "INFO");
			env.setIsGameWindowInitialized(true);
		}
        
        // Reset frame to make it empty
        WindowUtils.resetWindow(frame);

        // Frame Settings
        frame.setTitle(WindowNames.GAME.getWindowName());
        frame.setSize(948, 774);

        if(env.getResetWindowPosition()) {
			frame.setLocationRelativeTo(null);
			env.setResetWindowPosition(false);
		}


        // Main Panel
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		

		// North Panel
		JPanel northPanel = new JPanel();
		northPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		// Player 2 Label
		JLabel player2Label = new JLabel("Joueur 2");
		player2Label.setForeground(Color.BLUE);
		player2Label.setFont(new Font("Dialog", Font.BOLD, 21));

		if(env.getGameVariables().getCurrentPlayerTurn().getID() == 2) {
			player2Label.setBorder(new LineBorder(Color.RED, 2, true));
		} else {
			player2Label.setBorder(new LineBorder(Color.BLACK, 2, true));
		}

		northPanel.add(player2Label, BorderLayout.WEST);
		

		// West Panel
		JPanel westPanel = new JPanel();
		westPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new GridLayout(16, 1, 0, 0));
		
		// Player 1 Label
		JLabel player1Label = new JLabel("Joueur 1");
		player1Label.setForeground(Color.RED);
		player1Label.setFont(new Font("Dialog", Font.BOLD, 21));

		if(env.getGameVariables().getCurrentPlayerTurn().getID() == 1) {
			player1Label.setBorder(new LineBorder(Color.RED, 2, true));
		} else {
			player1Label.setBorder(new LineBorder(Color.BLACK, 2, true));
		}

		westPanel.add(player1Label);


		// South Panel
		JPanel southPanel = new JPanel();
		southPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new BorderLayout(0, 0));
		
		// Player 4 Label
		JLabel player4Label = new JLabel("Joueur 4");
		player4Label.setForeground(new Color(0, 128, 0));
		player4Label.setHorizontalAlignment(SwingConstants.TRAILING);
		player4Label.setFont(new Font("Dialog", Font.BOLD, 21));

		if(env.getGameVariables().getCurrentPlayerTurn().getID() == 4) {
			player4Label.setBorder(new LineBorder(Color.RED, 2, true));
		} else {
			player4Label.setBorder(new LineBorder(Color.BLACK, 2, true));
		}

		southPanel.add(player4Label, BorderLayout.WEST);
		

		// East Panel
		JPanel eastPanel = new JPanel();
		eastPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		mainPanel.add(eastPanel, BorderLayout.EAST);
		eastPanel.setLayout(new GridLayout(16, 1, 0, 0));
		
		// Player 3 Label
		JLabel player3Label = new JLabel("Joueur 3");
		player3Label.setForeground(Color.ORANGE);
		player3Label.setFont(new Font("Arial", Font.BOLD, 21));

		if(env.getGameVariables().getCurrentPlayerTurn().getID() == 3) {
			player3Label.setBorder(new LineBorder(Color.RED, 2, true));
		} else {
			player3Label.setBorder(new LineBorder(Color.BLACK, 2, true));
		}

		eastPanel.add(player3Label);
		

		// Map Image Panel
		Image mapImage = ImagePaths.GAME_MAP.getImageForPanelBGImage();

		JPanelWithBackgroundImage mapPanel = new JPanelWithBackgroundImage(ImagePaths.GAME_MAP.getImagePath());

		// Set "preferredSize" as the same size as the map so it doesn't get deformed when something is added in player areas
		mapPanel.setPreferredSize(new Dimension(mapImage.getWidth(null), mapImage.getHeight(null)));  
		mapPanel.setLayout(null);
		mainPanel.add(mapPanel, BorderLayout.CENTER);



        // [#] Hexagonal JButtons

		// Show every buttons
		Integer buttonToAdd = 0;
		
		for(int i = 0; i < BoardSlotProperties.ROW_AMOUNT; i++){

			
			if(i == 0 || i == 12) {
                buttonToAdd = BoardSlotProperties.BUTTON_TO_ADD_ROWS_0_12;
            } else if(i == 5 || i == 7) {
                buttonToAdd = BoardSlotProperties.BUTTON_TO_ADD_ROWS_5_7;
            } else if(i%2 == 1) {
                buttonToAdd =  BoardSlotProperties.BUTTON_TO_ADD_ROWS_ODD;
            } else if(i%2 == 0) {
                buttonToAdd = BoardSlotProperties.BUTTON_TO_ADD_ROWS_EVEN;
            } 

            for(int j = 0; j < buttonToAdd; j++) {
				/**
				 * "get(i)" : Get the row "i" containing an amount of slots
				 * "get(j)" : Get the Slot at position [i, j] in the map
				 */
				mapPanel.add( env.getGameVariables().getGameBoard().getBoardSlots().get(i).get(j).getHexagonButton() ) ;
            }
		}

		// Check "GameStatus" and perform action depending of its status
		GameEngine.checkCurrentGameStatus(env, mapPanel);


        // Revalidate to refresh the updated page
		frame.revalidate();
    }
}
