package com.theisland.windows;

import com.theisland.main.EnvironmentVariables;

public class WindowLibrary {

    private EnvironmentVariables env;
    // private TestWindow testWindow;
    private MainMenuWindow mainMenuWindow;
    private GameWindow gameWindow;


    public WindowLibrary(EnvironmentVariables env) {
        this.env = env;
        //this.introWindow = new TestWindow(this.env);
        this.mainMenuWindow = new MainMenuWindow(this.env);
        this.gameWindow = new GameWindow(this.env);
    }


    // Getters & Setters

    public void showMainMenuWindow(ProgramWindow programWindow) {
        mainMenuWindow.setView(programWindow.getFrame());
    }

    public void showGameWindow(ProgramWindow programWindow) {
        gameWindow.setView(programWindow.getFrame());
    }
}
