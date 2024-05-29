package com.theisland.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.theisland.enums.WindowNames;
import com.theisland.misc.EnhancedLog;
import com.theisland.windows.ProgramWindow;
import com.theisland.windows.WindowLibrary;

public class Main {
    

    private static ProgramWindow programWindow;
    
    public static void main(String[] args) {


        // Initialize environment variables
        EnvironmentVariables env = new EnvironmentVariables();
        env.initVariables();


        // Initialize Game Variables
        env.getGameVariables().initPlayers();
        env.getGameVariables().getGameBoard().init();
        env.getGameVariables().getGameBoard().initTiles();


        // Initialize main Frame
        programWindow = new ProgramWindow();
        programWindow.initialize();
        

        // Get available Frames
        WindowLibrary windowLibrary = new WindowLibrary(env);

        
        // Start program infinite loop until it get closed
        // "Timer" is more adapted than a "while()" loop to refresh the GUI 
            
        Timer t = new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(env.getRefreshWindow() == true) {
    
                    switch (env.getCurrentWindow()) {
                        case MAIN_MENU:
                            env.setRefreshWindow(false);
                            windowLibrary.showMainMenuWindow(programWindow);
                            EnhancedLog.eventLogger("Window \"" + WindowNames.MAIN_MENU.getWindowName() + "\" set !" , "INFO");
                            break;

                        case GAME:
                            env.setRefreshWindow(false);
                            windowLibrary.showGameWindow(programWindow);

                            if(env.getIsGameWindowInitialized() == false) {
                                EnhancedLog.eventLogger("Window \"" + WindowNames.DEFAULT.getWindowName() + "\" set !" , "INFO");
                            }
                            break;
                        
                        default:
                            break;
                    }
                }
            }
        });

        
        t.start();
    }    
}