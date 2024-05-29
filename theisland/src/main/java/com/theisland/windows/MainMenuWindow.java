package com.theisland.windows;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.theisland.enums.ImagePaths;
import com.theisland.enums.WindowNames;
import com.theisland.main.EnvironmentVariables;

public class MainMenuWindow {


    private EnvironmentVariables env;


	public MainMenuWindow(EnvironmentVariables env) {
		this.env = env;
	}


    public void setView(JFrame frame) {
        
        // Reset frame to make it empty
        WindowUtils.resetWindow(frame);

        // Frame Settings
        frame.setTitle(WindowNames.MAIN_MENU.getWindowName());
        frame.setSize(979, 631);

        // Center window on the screen on first initialization
		if(env.getResetWindowPosition()) {
			frame.setLocationRelativeTo(null);
			env.setResetWindowPosition(false);
		}


        // Main Panel Frame (With Background Image)
		JPanelWithBackgroundImage mainPanel = new JPanelWithBackgroundImage(ImagePaths.GAME_SPLASH.getImagePath());
		mainPanel.setLayout(null);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		// Play button
		JButton playButton = new JButton("JOUER");
		playButton.setFocusPainted(false);
		playButton.setFont(new Font("Arial", Font.BOLD, 82));
		playButton.setBounds(301, 427, 360, 126);
        playButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Update environmet variables
				env.setCurrentWindow(WindowNames.GAME);
				env.setRefreshWindow(true);
				env.setResetWindowPosition(true);
			}
        });

		mainPanel.add(playButton);


        // Revalidate to refresh the updated page
		frame.revalidate();
    }
}
