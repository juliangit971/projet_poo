package com.theisland.windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.theisland.enums.ImagePaths;
import com.theisland.enums.WindowNames;
import com.theisland.gameelements.BoardSlotProperties;
import com.theisland.gameelements.GameBoard;
import com.theisland.main.EnvironmentVariables;
import com.theisland.misc.EnhancedLog;

public class GameWindow {


    private EnvironmentVariables env;


	public GameWindow(EnvironmentVariables env) {
		this.env = env;
	}


    public void setView(JFrame frame) {
        
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



        // [#] Hexagonal JButtons

		Integer buttonToAdd = 0;

		GameBoard gb = new GameBoard();
		gb.init();
		
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
				mapPanel.add( gb.getBoardSlots().get(i).get(j).getHexagonButton() ) ;
            }
		}


        // Revalidate to refresh the updated page
		frame.revalidate();

        
        // Log
        EnhancedLog.eventLogger("Window \"" + WindowNames.DEFAULT.getWindowName() + "\" set !" , "INFO");
    }
}
