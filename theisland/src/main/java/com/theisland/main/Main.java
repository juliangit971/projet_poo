package com.theisland.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.theisland.windows.ProgramWindow;
import com.theisland.windows.WindowLibrary;

public class Main {
    

    private static ProgramWindow programWindow;
    
    public static void main(String[] args) {


        // Initialize environment variables
        EnvironmentVariables env = new EnvironmentVariables();
        env.initVariables();


        // Initialize main Frame
        programWindow = new ProgramWindow();
        programWindow.initialize();
        

        // Get available Frames
        WindowLibrary windowLibrary = new WindowLibrary(env);

        
        // Start program infinite loop until it get closed
        // "Timer" est plus adapté qu'une boucle "while()" pour rafraichir l'interface 
            
        Timer t = new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(env.getRefreshWindow() == true) {
    
                    switch (env.getCurrentWindow()) {
                        case MAIN_MENU:
                            windowLibrary.showMainMenuWindow(programWindow);
                            env.setRefreshWindow(false);
                            break;

                        case GAME:
                            windowLibrary.showGameWindow(programWindow);
                            env.setRefreshWindow(false);
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